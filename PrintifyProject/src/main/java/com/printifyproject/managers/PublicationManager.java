package com.printifyproject.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.printifyproject.orm.model.*;
import com.printifyproject.printifyapi.api.ApiProduct;
import com.printifyproject.printifyapi.api.ApiShop;
import com.printifyproject.printifyapi.api.ApiUpload;
import com.printifyproject.printifyapi.product.Product;
import com.printifyproject.printifyapi.shop.Shop;
import com.printifyproject.printifyapi.upload.Image;
import com.printifyproject.printifyapi.upload.PagedImages;
import com.printifyproject.printifyapi.upload.UploadImageBodyRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class   PublicationManager {
    private final Logger logger;
    private final ProductEntity product;
    private JsonNodeFactory factory;
    private final DesignEntity design;
    private final PrintSpecEntity printSpec;
    private final Set<PrintSpecColorEntity> printSpecColors;
    private final BlueprintEntity blueprint;
    private final PrintProviderEntity printProvider;
    private final Set<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants;
    private final Set<Integer> variantIds;
    private ArrayNode variantsArray;
    private ArrayNode printAreasArray;
    private final ApiUpload apiUpload;
    private final ApiShop apiShop;
    private final ApiProduct apiProduct;
    private String imageId;
    private String json ;

    public PublicationManager(ProductEntity product) {
        this.product = product;
        if (product.isPublished())
            throw new IllegalArgumentException("Cannot publish a published product");

        if (product.getProductKey().isEmpty())
            throw new IllegalArgumentException("Cannot publish a product that has not been uploaded");

        logger = LogManager.getLogger();
        apiUpload = new ApiUpload(logger);
        apiProduct = new ApiProduct(logger);
        apiShop = new ApiShop(logger);

        this.design = product.getDesign();
        this.printSpec = product.getPrintSpec();
        this.printSpecColors = printSpec.getColors();
        BlueprintPrintProviderEntity blueprintPrintProvider = printSpec.getBlueprintPrintProvider();

        this.blueprint = blueprintPrintProvider.getBlueprint();
        this.printProvider = blueprintPrintProvider.getPrintProvider();
        this.blueprintPrintProviderVariants = blueprintPrintProvider.getBlueprintPrintProviderVariants();
        this.variantIds = new HashSet<>();
    }

    public void UploadProductToPrintify() {
        if (product.getProductId() == 0)
            return;

        processImage();
        buildProductJson();
        apiUploadProductToPrintify();
    }

    private void processImage() {
        String fileName = product.getDesign().getImage();
        try {
            getUploadedImageId(fileName);

            if (this.imageId.isEmpty()) {
                uploadImage(fileName);
            }
        } catch (IOException e) {
            logger.error("Error while processing image: " + e.getMessage(), e);
        }
    }

    private void getUploadedImageId(String fileName) {
        int page = 1;

        while (true) {
            PagedImages images = this.apiUpload.GetUploads(100, page);
            Optional<Image> imageOptional = images.getData()
                    .stream()
                    .filter(i -> i.getFileName().equals(fileName))
                    .findFirst();

            imageOptional.ifPresent(image -> imageId = image.getId());

            if (images.getData().isEmpty()) {
                break;
            }
            page++;
        }
    }

    private void uploadImage(String fileName) throws IOException {
        ClassLoader classLoader = PublicationManager.class.getClassLoader();
        java.net.URL resourceUrl = classLoader.getResource("images/"+fileName);
        assert resourceUrl != null;
        String filePath = resourceUrl.getFile();

        if (Files.exists(Path.of(filePath))) {
            String contents = encodeFile(filePath);
            UploadImageBodyRequest uploadImageBodyRequest = new UploadImageBodyRequest();
            uploadImageBodyRequest.setFileName(fileName);
            uploadImageBodyRequest.setContents(contents);
            imageId = this.apiUpload.uploadImage(uploadImageBodyRequest).getId();
        }
    }
    private static String encodeFile(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));
        return Base64.getEncoder().encodeToString(fileBytes);
    }

    public void buildProductJson() {
        this.factory = JsonNodeFactory.instance;

        buildVariantArray();
        buildPrintAreasArray();

        ObjectNode rootNode = factory.objectNode();
        rootNode.put("title", design.getTitle() + " - " + printSpec.getName());
        rootNode.put("description", design.getDescription());
        rootNode.put("blueprint_id", blueprint.getBlueprintKey());
        rootNode.put("print_provider_id", printProvider.getPrintProviderKey());
        rootNode.set("variants", this.variantsArray);
        rootNode.set("print_areas", this.printAreasArray);

        System.out.println(rootNode.toString());
    }

    private void buildVariantArray() {
        variantsArray = factory.arrayNode();

        for (BlueprintPrintProviderVariantEntity variant : blueprintPrintProviderVariants) {
            ObjectNode variantNode = factory.objectNode();
            int variantId = variant.getVariantKey();
            variantNode.put("id", variantId);
            String colorToCheck = variant.getColor().getColor();
            variantNode.put("is_enabled", printSpecColors.stream()
                .anyMatch(printSpecColor -> colorToCheck.equals(printSpecColor.getColor().getColor())));
            variantIds.add(variantId);
            variantsArray.add(variantNode);
        }
    }

    private void buildPrintAreasArray() {
        ObjectNode printAreaNode = factory.objectNode();

        ArrayNode variantIdsNode = buildVariantIdsNode();
        printAreaNode.set("variant_ids", variantIdsNode);

        ArrayNode placeholdersArray = buildPlaceholderNode();
        printAreaNode.set("placeholders", placeholdersArray);

        printAreasArray = factory.arrayNode();
        printAreasArray.add(printAreaNode);
    }

    private ArrayNode buildVariantIdsNode() {
        ArrayNode variantIdsNode = factory.arrayNode();
        for (Integer variantId : variantIds) {
            variantIdsNode.add(variantId);
        }

        return variantIdsNode;
    }

    private ArrayNode buildPlaceholderNode() {
        ArrayNode imagesArray = buildImagesArray();

        //Placeholder
        ObjectNode placeholderNode = factory.objectNode();
        placeholderNode.put("position", "front");
        placeholderNode.set("images", imagesArray);
        ArrayNode placeholdersArray = factory.arrayNode();
        placeholdersArray.add(placeholderNode);
        return placeholdersArray;
    }
    private ArrayNode buildImagesArray() {
        ObjectNode imageNode = factory.objectNode();
        imageNode.put("id", imageId);
        ArrayNode imagesArray = factory.arrayNode();
        imagesArray.add(imageNode);

        return imagesArray;
    }

    private void apiUploadProductToPrintify() {
        try {
            int shopId = apiShop.getShops().stream().findFirst().orElse(new Shop()).getShopId();
            ObjectMapper objectMapper = new ObjectMapper();
            Product printifyProduct = objectMapper.readValue(json, Product.class);
            printifyProduct = apiProduct.CreateProduct(shopId, printifyProduct);
            product.setProductKey(printifyProduct.getProductKey());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void PublishPrintify() {
        int shopId = apiShop.getShops().stream().findFirst().orElse(new Shop()).getShopId();
        apiProduct.PublishProduct(shopId, product.getProductKey());
        product.setPublished(true);
    }

    public ProductEntity getProduct() {
        return product;
    }

}

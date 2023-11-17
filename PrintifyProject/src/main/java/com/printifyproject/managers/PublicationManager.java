package com.printifyproject.managers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.printifyproject.orm.model.*;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;
import com.printifyproject.printifyapi.api.ApiUpload;
import com.printifyproject.printifyapi.upload.Image;
import com.printifyproject.printifyapi.upload.PagedImages;
import com.printifyproject.printifyapi.upload.UploadImageBodyRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

public class   PublicationManager {
    private static final Logger logger = LogManager.getLogger();

    public static ProductEntity UploadProductToPrintify(ProductEntity entity) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        ProductService productService = serviceHelper.getProductService();

        if (entity.getProductId() == 0)
            return null;

        String imageId = processImage(entity.getDesign().getImage());

        //todo: create product schema
        String json =  buildProductJson(entity, imageId);

        //todo: upload product, if it is not there


        //todo: get productkey

        //todo: update productkey, isPublished=1
        entity.setPublished(true);
        entity.setProductKey(UUID.randomUUID().toString());
        productService.update(entity);

        return entity;
    }


    public static String buildProductJson (ProductEntity entity,String imageId) {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode rootNode = factory.objectNode();

        DesignEntity design = entity.getDesign();
        PrintSpecEntity printSpec = entity.getPrintSpec();
        BlueprintEntity blueprint = printSpec.getBlueprintPrintProvider().getBlueprint();
        PrintProviderEntity printProvider = printSpec.getBlueprintPrintProvider().getPrintProvider();

        rootNode.put("title", design.getTitle() + " - " + entity.getPrintSpec().getName());
        rootNode.put("description", design.getDescription());
        rootNode.put("blueprint_id", blueprint.getBlueprintKey());
        rootNode.put("print_provider_id", printProvider.getPrintProviderKey());

        ArrayNode variantsArray = factory.arrayNode();

        ArrayNode printAreasArray = factory.arrayNode();

        //Images for Placeholder
        ObjectNode imageObject = factory.objectNode();
        imageObject.put("id", imageId);
        ArrayNode imagesArray  = factory.arrayNode();
        imagesArray.add(imageObject);

        //Placeholder
        ObjectNode placeholdersNode = factory.objectNode();
        placeholdersNode.put("position", "front");
        placeholdersNode.set("images", imagesArray);

        return "";
    }



    private static ProductEntity UploadProductToPrintify(ProductEntity entity, String productSchema) {

        return entity;
    }

    public static ProductEntity publishPrintify(ProductEntity entity) {


        entity.setProductKey(UUID.randomUUID().toString());
        return entity;
    }


    private static String processImage(String fileName) {
        String imageId = "";

        try {
            ApiUpload apiUpload = new ApiUpload(logger);
            imageId = getUploadImageId(apiUpload, fileName);

            if (imageId.isEmpty()) {
                imageId = uploadImage(apiUpload, fileName);
            }
        } catch(IOException e) {
            logger.error("Error while processing image: " + e.getMessage(), e);
        }

        return imageId;
    }

    private static String uploadImage(ApiUpload apiUpload, String fileName) throws IOException {
        String userDirectoryPath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\printifyproject\\images\\";
        String filePath = userDirectoryPath + fileName;

        if (Files.exists(Path.of(filePath))) {
            String contents = encodeFile(filePath);

            UploadImageBodyRequest uploadImageBodyRequest = new UploadImageBodyRequest();
            uploadImageBodyRequest.setFileName(fileName);
            uploadImageBodyRequest.setContents(contents);
            var image = apiUpload.uploadImage(uploadImageBodyRequest);
            return image.getId();
        }

        return "";
    }

    private static String getUploadImageId(ApiUpload apiUpload, String fileName) {
        int page = 1;

        while (true) {
            PagedImages images = apiUpload.GetUploads(100, page);
            if (images.getData().isEmpty()) {
                break;
            }
            if (images.getData().stream().anyMatch(i -> i.getFileName().equals(fileName))) {
                Image item = images.getData().stream()
                        .filter(i -> i.getFileName().equals(fileName))
                        .findFirst()
                        .orElse(null);

                if (item != null) {
                    return item.getId();
                }
            }
            page++;
        }
        return "";
    }

    private static String encodeFile(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}

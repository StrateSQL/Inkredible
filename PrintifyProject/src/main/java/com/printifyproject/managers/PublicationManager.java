package com.printifyproject.managers;

import com.printifyproject.orm.model.ProductEntity;
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
import java.util.Optional;
import java.util.UUID;

public class   PublicationManager {
    private static final Logger logger = LogManager.getLogger();

    public static ProductEntity UploadProductToPrintify(ProductEntity entity) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        ProductService productService = serviceHelper.getProductService();

        Optional<ProductEntity> optProduct = productService.findById(entity.getProductId());

        if (optProduct.isPresent()) {
            var product = optProduct.get();
            product.setPublished(true);
            product.setProductKey(UUID.randomUUID().toString());

            //todo: upload image if it is not already uploaded

            //todo: upload product, if it is not there

            //todo: get productkey

            //todo: update productkey, isPublished=1
            product.setPublished(true);
            product.setProductKey(UUID.randomUUID().toString());
            productService.update(product);

            return entity;
        } else
            return entity;
    }

    public static ProductEntity publishPrintify(ProductEntity entity) {
        return null;
    }

    public static String processImage(String fileName) {
        String imageId = "";

        try {
            ApiUpload apiUpload = new ApiUpload(logger);
            imageId = getUploadImageId(apiUpload, fileName);

            if (imageId.isEmpty()) {
                uploadImage(apiUpload, fileName);
            }
        } catch(IOException e) {
            logger.error("Error while processing image: " + e.getMessage(), e);
        }

        return imageId;
    }

    private static String uploadImage(ApiUpload apiUpload, String fileName) throws IOException {
        String userDirectoryPath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\printifyproject\\images\\";
        String filePath = userDirectoryPath + fileName;

        filePath = "D:\\Dropbox\\T-Shirts\\00-Designs Available\\Autumn Summer\\1.png";
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

package com.printifyproject.managers;

import com.printifyproject.orm.model.ProductEntity;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;

import java.util.Optional;
import java.util.UUID;

public class   PublicationManager {
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
        }
        else
            return entity;
    }

    public static ProductEntity publishPrintify (ProductEntity entity) {
        return null;
    }

    public static void UploadImage(String image) {
        //todo: check if image has already been uploaded


        //todo: if note uploaded, then upload
    }

    public static String GetUploadImageId(String fileName) {


        return "imageid";
    }
}

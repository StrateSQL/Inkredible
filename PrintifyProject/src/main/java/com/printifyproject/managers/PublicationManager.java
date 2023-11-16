package com.printifyproject.managers;

import com.printifyproject.orm.model.ProductEntity;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;

import java.util.Optional;
import java.util.UUID;

public class   PublicationManager {
    public static boolean UploadProductToPrintify(int productId) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        ProductService productService = serviceHelper.getProductService();

        Optional<ProductEntity> optProduct = productService.findById(productId);

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

            return true;
        }
        else
            return false;
    }

    public void UploadImage(String image) {
        //todo: check if image has already been uploaded

        //todo: if note uploaded, then upload
    }
}

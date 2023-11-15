package com.printifyproject.managers;

import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;

public class PublicationManager {
    public void UploadPrint (int productId) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        ProductService productService = serviceHelper.getProductService();

        productService.findById(productId);

        //todo: upload image if it is not already uploaded

        //todo: publish
    }
}

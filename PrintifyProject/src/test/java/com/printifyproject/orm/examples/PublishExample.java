package com.printifyproject.orm.examples;

import com.printifyproject.orm.model.DesignEntity;
import com.printifyproject.orm.model.ProductEntity;
import com.printifyproject.orm.service.DesignService;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;

import java.util.List;
import java.util.Optional;
public class PublishExample {
    public static void publishProduct() {
        //This example method walks through all the steps in the "Creating a PrintSpec"
        //sequence document
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();

        //List all designs to user
        DesignService designService = serviceHelper.getDesignService();
        List<DesignEntity> designs = designService.findAll();

        //select design 2
        Optional<DesignEntity> optDesign = designs.stream()
                .filter(d -> d.getDesignId() == 2)
                .findFirst();

        if (optDesign.isPresent()) {
            DesignEntity design = optDesign.get();

            ProductService productService = serviceHelper.getProductService();

            //return list of all available products and publication status
            List<ProductEntity> products = productService.findAll()
                    .stream()
                    .filter(product -> product.getDesign().getDesignId() == 2)
                    .toList();

            //select product 3
            Optional<ProductEntity> optProduct = products.stream()
                    .filter(d -> d.getProductId() == 3)
                    .findFirst();

            if (optProduct.isPresent()) {
                ProductEntity product = optProduct.get();

                //send product to update on printify
                //wait for response
                product = productService.uploadPrintifyProduct(product);

                //publish after updated
                product = productService.publishPrintify(product);

                System.out.println(product.toString());
            }
        }
    }
}

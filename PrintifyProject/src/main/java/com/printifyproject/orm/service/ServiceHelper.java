package com.printifyproject.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceHelper {

    private static ApplicationContext applicationContext;
    private BlueprintPrintProviderService blueprintPrintProviderService;
    private BlueprintPrintProviderVariantService blueprintPrintProviderVariantService;
    private BlueprintService blueprintService;
    private ColorService colorService;
    private DesignService designService;
    private PrintProviderService printProviderService;
    private PrintSpecColorService printSpecColorService;
    private PrintSpecService printSpecService;
    private PrintSpecSizeService printSpecSizeService;
    private ProductService productService;
    private SizeService sizeService;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ServiceHelper.applicationContext = applicationContext;
    }

    public static void initContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("spring.xml");;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BlueprintPrintProviderService getBlueprintPrintProviderService() {
        if (this.blueprintPrintProviderService == null) {
            this.blueprintPrintProviderService = applicationContext.getBean(BlueprintPrintProviderService.class);
        }
        return this.blueprintPrintProviderService;
    }

    public BlueprintPrintProviderVariantService getBlueprintPrintProviderVariantService() {
        if (this.blueprintPrintProviderVariantService == null) {
            this.blueprintPrintProviderVariantService = applicationContext.getBean(BlueprintPrintProviderVariantService.class);
        }
        return this.blueprintPrintProviderVariantService;
    }

    public BlueprintService getBlueprintService() {
        if (this.blueprintService == null) {
            this.blueprintService = applicationContext.getBean(BlueprintService.class);
        }
        return this.blueprintService;
    }

    public ColorService getColorService() {
        if (this.colorService == null) {
            this.colorService = applicationContext.getBean(ColorService.class);
        }
        return this.colorService;
    }

    public DesignService getDesignService() {
        if (this.designService == null) {
            this.designService = applicationContext.getBean(DesignService.class);
        }
        return this.designService;
    }

    public PrintProviderService getPrintProviderService() {
        if (this.printProviderService == null) {
            this.printProviderService = applicationContext.getBean(PrintProviderService.class);
        }
        return this.printProviderService;
    }

    public PrintSpecColorService getPrintSpecColorService() {
        if (this.printSpecColorService == null) {
            this.printSpecColorService = applicationContext.getBean(PrintSpecColorService.class);
        }
        return this.printSpecColorService;
    }

    public PrintSpecService getPrintPrintSpecService() {
        if (this.printSpecService == null) {
            this.printSpecService = applicationContext.getBean(PrintSpecService.class);
        }
        return this.printSpecService;
    }

    public PrintSpecSizeService getPrintSpecSizeService() {
        if (this.printSpecSizeService == null) {
            this.printSpecSizeService = applicationContext.getBean(PrintSpecSizeService.class);
        }
        return this.printSpecSizeService;
    }

    public ProductService getProductService() {
        if (this.productService == null) {
            this.productService = applicationContext.getBean(ProductService.class);
        }
        return this.productService;
    }

    public SizeService getSizeService() {
        if (this.sizeService == null) {
            this.sizeService = applicationContext.getBean(SizeService.class);
        }
        return this.sizeService;
    }
}

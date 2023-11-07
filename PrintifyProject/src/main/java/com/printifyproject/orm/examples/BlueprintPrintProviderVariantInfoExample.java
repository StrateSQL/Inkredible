package com.printifyproject.orm.examples;

import com.printifyproject.orm.service.BlueprintPrintProviderVariantInfoService;
import com.printifyproject.orm.service.ServiceHelper;

public class BlueprintPrintProviderVariantInfoExample {

    public static void BuildBlueprintPrintProviderVariantInfo() {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        Integer blueprintPrintProviderId = 123;
        BlueprintPrintProviderVariantInfoService service
                    = new BlueprintPrintProviderVariantInfoService(blueprintPrintProviderId);

        //System.out.println(Arrays.stream(service.getNames().toArray()).toList());
    }

}

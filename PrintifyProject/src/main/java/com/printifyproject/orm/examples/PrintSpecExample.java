package com.printifyproject.orm.examples;

import com.printifyproject.orm.service.BlueprintPrintProviderService;
import com.printifyproject.orm.service.PrintSpecService;
import com.printifyproject.orm.service.ServiceHelper;
public class PrintSpecExample {
    public static void createPrintSpec () {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        PrintSpecService printSpecService = serviceHelper.getPrintPrintSpecService();
        BlueprintPrintProviderService blueprintPrintProviderService = serviceHelper.getBlueprintPrintProviderService();

        BlueprintPrintProviderEntity blueprintPrintProviderEntity = blueprintPrintProviderService.findByKeys()



    }
}

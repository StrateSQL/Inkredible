package com.printifyproject.orm.examples;

import com.printifyproject.orm.service.PrintProviderService;
import com.printifyproject.orm.service.ServiceHelper;

import java.util.Arrays;

public class PrintProviderExample {



    public static void createNameList() {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        PrintProviderService printProviderService = serviceHelper.getPrintProviderService();
        System.out.println(Arrays.stream(printProviderService.getNames().toArray()).toList());
    }
}

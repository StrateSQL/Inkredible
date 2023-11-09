package com.printifyproject.orm.examples;

import com.printifyproject.orm.model.*;
import com.printifyproject.orm.service.*;

import java.util.*;

public class PrintSpecExample {
    public static void createPrintSpec () {
        //This example method walks through all the steps in the "Creating a PrintSpec"
        //sequence document
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();

        BlueprintService blueprintService = serviceHelper.getBlueprintService();
        List<String> blueprintTitles = blueprintService.getTitles();
        System.out.println(Arrays.toString(blueprintTitles.toArray()));

        String title = "Quality Men's T-Shirt";
        System.out.println(title);

        String blueprintTitle = "Champion T-Shirt";
        System.out.println(blueprintTitle);

        Optional<BlueprintEntity> optBlueprint = blueprintService.getBlueprintByTitle(blueprintTitle);

        if (optBlueprint.isPresent()) {
            BlueprintEntity blueprint = optBlueprint.get();
            System.out.println(blueprint.toString());

            BlueprintPrintProviderService blueprintPrintProviderService = serviceHelper.getBlueprintPrintProviderService();
            List<String> printProviderNames = blueprintPrintProviderService.getPrintProviderNames(blueprint.getBlueprintId());
            System.out.println(Arrays.toString(printProviderNames.toArray()));

            String printProviderName = "Awkward Styles";
            System.out.println(printProviderName);

            PrintProviderService printProviderService = serviceHelper.getPrintProviderService();
            Optional<PrintProviderEntity> optPrintProvider = printProviderService.getPrintProviderByName(printProviderName);

            if (optPrintProvider.isPresent()) {
                PrintProviderEntity printProvider = optPrintProvider.get();
                System.out.println(printProvider.toString());

                Optional<BlueprintPrintProviderEntity> optBlueprintPrintProvider = blueprintPrintProviderService.findByKeys(blueprint, printProvider);

                if (optBlueprintPrintProvider.isPresent()) {
                    BlueprintPrintProviderEntity blueprintPrintProvider = optBlueprintPrintProvider.get();

                    ColorService colorService = serviceHelper.getColorService();
                    Set<String> colors = colorService.getColorsByBlueprintPrintProviderId(blueprintPrintProvider.getId());
                    System.out.println(Arrays.toString(colors.toArray()));

                    List<String> selectColors = List.of("Royal Blue", "Black", "Charcoal Heather");
                    System.out.println(Arrays.toString(selectColors.toArray()));

                    //Set<String> selectColorSet =
                    PrintSpecColorService printSpecColorService = serviceHelper.getPrintSpecColorService();

                    PrintSpecEntity printSpec = new PrintSpecEntity();
                    printSpec.setName(title);
                    printSpec.setBlueprintPrintProvider(blueprintPrintProvider);
                    printSpec.setGossMargin(40d);

                    Set<PrintSpecColorEntity> printSpecColors = new HashSet<>();
                    for (String colorName : selectColors) {
                        ColorEntity colorEntity = colorService.findByColor(colorName); // Implement this method
                        PrintSpecColorEntity printSpecColor = new PrintSpecColorEntity(printSpec, colorEntity);

                        // Add to the PrintSpecColorEntity set
                        printSpecColors.add(printSpecColor);
                    }
                    printSpec.setColors(printSpecColors);
                    PrintSpecService printSpecService = serviceHelper.getPrintSpecService();
                    printSpec = printSpecService.add(printSpec);
                    printSpecService.delete(printSpec);
                }
            }
        }


    }
}

package com.printifyproject.printifyapi.loader;

public class PrintifyLoader {
    public static void process() {
        PrintProviderLoader printProviderLoader = new PrintProviderLoader();
        printProviderLoader.process();

        BlueprintLoader blueprintLoader = new BlueprintLoader();
        blueprintLoader.process();

        BlueprintPrintProviderLoader blueprintPrintProviderLoader = new BlueprintPrintProviderLoader();
        blueprintPrintProviderLoader.process();
    }
}

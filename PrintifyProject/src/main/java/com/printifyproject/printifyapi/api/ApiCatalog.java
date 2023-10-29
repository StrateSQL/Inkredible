package com.printifyproject.printifyapi.api;

import com.printifyproject.printifyapi.catalog.Blueprint;
import com.printifyproject.printifyapi.catalog.PrintProvider;
import com.printifyproject.printifyapi.catalog.Shipping;
import com.printifyproject.printifyapi.catalog.VariantSet;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApiCatalog {

    private final ApiConnector apiConnector;

    public ApiCatalog(Logger logger) {
        apiConnector = new ApiConnector(logger);
    }

    public Blueprint getBlueprint(int blueprintId) {
        var endpoint = String.format("catalog/blueprints/%s.json", blueprintId);
        return apiConnector.getObject(endpoint, Blueprint.class);
    }

    public List<Blueprint> getBlueprints() {
        var endpoint = "catalog/blueprints.json";
        return apiConnector.getList(endpoint, Blueprint.class);
    }

    public PrintProvider getPrintProvider(int printProviderId) {
        var endpoint = String.format("catalog/print_providers/%s.json", printProviderId);
        return apiConnector.getObject(endpoint, PrintProvider.class);
    }

    public List<PrintProvider> getPrintProviders() {
        var endpoint = "catalog/print_providers.json";
        return apiConnector.getList(endpoint, PrintProvider.class);
    }

    public List<PrintProvider> getPrintProviders(int blueprintId) {
        var endpoint = String.format("catalog/blueprints/%s/print_providers.json", blueprintId);
        return apiConnector.getList(endpoint, PrintProvider.class);
    }

    public Shipping getShipping(int blueprintId, int printProviderId) {
        var endpoint = String.format("catalog/blueprints/%s/print_providers/%s/shipping.json", blueprintId, printProviderId);
        return apiConnector.getObject(endpoint, Shipping.class);
    }

    public VariantSet getVariants(int blueprintId, int printProviderId) {
        var endpoint = String.format("catalog/blueprints/%s/print_providers/%s/variants.json", blueprintId, printProviderId);
        return apiConnector.getObject(endpoint, VariantSet.class);
    }
}

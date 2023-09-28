package com.capstone.printify.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class PrintifyCatalog {

//    private final Logger logger = LoggerFactory.getLogger(APIClient.class);
//    private final HttpClient httpClient; // Replace with your HTTP client
//
//    public APIClient(HttpClient httpClient) {
//        this.httpClient = httpClient;
//    }
//
//    public Blueprint getBlueprint(int blueprintId) throws IOException {
//        logger.info("GET: /v1/catalog/blueprints/{}.json", blueprintId);
//        String json = httpClient.getString("/catalog/blueprints/" + blueprintId + ".json");
//        logger.trace(json);
//        return JsonUtils.deserialize(json, Blueprint.class);
//    }
//
//    public List<Blueprint> getBlueprints() throws IOException {
//        logger.info("GET: /v1/catalog/blueprints.json");
//        String json = httpClient.getString("/catalog/blueprints.json");
//        logger.trace(json);
//        return JsonUtils.deserializeList(json, Blueprint.class);
//    }
//
//    public PrintProvider getPrintProvider(int printProviderId) throws IOException {
//        logger.info("GET: /v1/catalog/print_providers/{}.json", printProviderId);
//        String json = httpClient.getString("/catalog/print_providers/" + printProviderId + ".json");
//        logger.trace(json);
//        return JsonUtils.deserialize(json, PrintProvider.class);
//    }
//
//    public List<PrintProvider> getPrintProviders() throws IOException {
//        logger.info("GET: /v1/catalog/print_providers.json");
//        String json = httpClient.getString("/catalog/print_providers.json");
//        logger.trace(json);
//        return JsonUtils.deserializeList(json, PrintProvider.class);
//    }
//
//    public List<PrintProvider> getPrintProviders(int blueprintId) throws IOException {
//        logger.info("GET: /v1/catalog/blueprints/{}/print_providers.json", blueprintId);
//        String json = httpClient.getString("/catalog/blueprints/" + blueprintId + "/print_providers.json");
//        logger.trace(json);
//        return JsonUtils.deserializeList(json, PrintProvider.class);
//    }
//
//    public Shipping getShipping(int blueprintId, int printProviderId) throws IOException {
//        logger.info("GET: /v1/catalog/blueprints/{}/print_providers/{}/shipping.json", blueprintId, printProviderId);
//        String json = httpClient.getString("/catalog/blueprints/" + blueprintId + "/print_providers/" + printProviderId + "/shipping.json");
//        logger.trace(json);
//        return JsonUtils.deserialize(json, Shipping.class);
//    }
//
//    public Variant getVariants(int blueprintId, int printProviderId) throws IOException {
//        logger.info("GET: /v1/catalog/blueprints/{}/print_providers/{}/variants.json", blueprintId, printProviderId);
//        String json = httpClient.getString("/catalog/blueprints/" + blueprintId + "/print_providers/" + printProviderId + "/variants.json");
//        logger.trace(json);
//        return JsonUtils.deserialize(json, Variant.class);
//    }
}

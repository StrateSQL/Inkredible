package com.printifyproject.printifyapi.api;

import com.printifyproject.printifyapi.upload.Image;
import com.printifyproject.printifyapi.upload.PagedImages;
import com.printifyproject.printifyapi.upload.UploadImageBodyRequest;
import com.printifyproject.printifyapi.upload.UploadImageQueryStringRequest;
import org.apache.logging.log4j.Logger;

public class ApiUpload {
    private final ApiConnector apiConnector;

    public ApiUpload(Logger logger) {
        apiConnector = new ApiConnector(logger);
    }

    public void ArchiveUploadedImage(String id) {
        var endpoint = String.format("uploads/%s/archive.json", id);
        apiConnector.postObject(endpoint);
    }

    public Image GetUploadedImage(String id) {
        String endpoint = String.format("uploads/%s.json", id);
        return apiConnector.getObject(endpoint, Image.class);
    }

    public PagedImages GetUploads() {
        return GetUploads(null, null);
    }


    public PagedImages GetUploads(Integer page) {
        return GetUploads(null, page);
    }

    public PagedImages GetUploads(Integer limit, Integer page) {
        StringBuilder endpoint = new StringBuilder("uploads.json");

        if (limit != null || page != null) {
            endpoint.append("?");

            if (limit != null) {
                endpoint.append("limit=").append(limit);
            }

            if (page != null) {
                if (limit != null) {
                    endpoint.append("&");
                }
                endpoint.append("page=").append(page);
            }
        }
        return apiConnector.getObject(endpoint.toString(), PagedImages.class);
    }


    public Image uploadImage(UploadImageBodyRequest uploadImageBodyRequest) {
        String endpoint = "uploads/images.json";
        return apiConnector.postObject(endpoint, uploadImageBodyRequest, Image.class);
    }

    public Image uploadImage(UploadImageQueryStringRequest uploadImageQueryStringRequest) {
        String endpoint = "uploads/images.json";
        return apiConnector.postObject(endpoint, uploadImageQueryStringRequest, Image.class);
    }
}

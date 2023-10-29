package com.printifyproject.printifyapi.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;

public class UploadImageQueryStringRequest {
    @JsonProperty("file_name")
    private String FileName;

    private URI Url = URI.create("");

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        this.FileName = fileName;
    }

    public URI getUrl() {
        return Url;
    }

    public void setUrl(URI url) {
        this.Url = url;
    }
}

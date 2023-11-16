package com.printifyproject.printifyapi.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadImageBodyRequest {
    @JsonProperty("contents")
    private String contents = "base-64-encoded-content";

    @JsonProperty("file_name")
    private String fileName;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

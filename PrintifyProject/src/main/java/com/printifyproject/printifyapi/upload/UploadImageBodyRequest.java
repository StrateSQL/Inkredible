package com.printifyproject.printifyapi.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadImageBodyRequest {
    private String Contents = "base-64-encoded-content";

    @JsonProperty("file_name")
    private String FileName;

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        this.Contents = contents;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        this.FileName = fileName;
    }
}

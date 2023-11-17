package com.printifyproject.printifyapi.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public class Image {
    @JsonProperty("id")
    private String Id;

    @JsonProperty("file_name")
    private String FileName;

    @JsonProperty("height")
    private Integer Height;

    @JsonProperty("width")
    private Integer Width;

    @JsonProperty("size")
    private Long Size;

    @JsonProperty("mime_type")
    private String MimeType;

    @JsonProperty("preview_url")
    private URI PreviewUrl;

    @JsonProperty("upload_time")
    private String UploadTime;


    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        this.FileName = fileName;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        this.Height = height;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        this.MimeType = mimeType;
    }

    public URI getPreviewUrl() {
        return PreviewUrl;
    }

    public void setPreviewUrl(URI previewUrl) {
        this.PreviewUrl = previewUrl;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        this.Size = size;
    }

    public String getUploadTime() {
        return UploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.UploadTime = uploadTime;
    }

    public Integer getWidth() {
        return Width;
    }

    public void setWidth(Integer width) {
        this.Width = width;
    }
}

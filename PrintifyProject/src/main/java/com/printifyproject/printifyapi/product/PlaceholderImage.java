package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PlaceholderImage {
    @JsonProperty("id")
    private String ImageKey;

    @JsonProperty("name")
    private String Name;

    @JsonProperty("type")
    private String Type;

    @JsonProperty("height")
    private Integer Height;

    @JsonProperty("width")
    private Integer Width;

    @JsonProperty("x")
    private Double X;

    @JsonProperty("y")
    private Double Y;

    @JsonProperty("scale")
    private Double Scale;

    @JsonProperty("angle")
    private Integer Angle;

    @JsonProperty("size")
    private Double Size;

    @JsonProperty("mime_type")
    private String MimeType;

    @JsonProperty("preview_url")
    private String PreviewUrl;

    @JsonProperty("upload_time")
    private Date UploadTime;

    public String getImageKey() {
        return ImageKey;
    }

    public void setImageKey(String imageKey) {
        this.ImageKey = imageKey;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        this.Height = height;
    }

    public Integer getWidth() {
        return Width;
    }

    public void setWidth(Integer width) {
        this.Width = width;
    }

    public Double getX() {
        return X;
    }

    public void setX(Double x) {
        this.X = x;
    }

    public Double getY() {
        return Y;
    }

    public void setY(Double y) {
        this.Y = y;
    }

    public Double getScale() {
        return Scale;
    }

    public void setScale(Double scale) {
        this.Scale = scale;
    }

    public Integer getAngle() {
        return Angle;
    }

    public void setAngle(Integer angle) {
        this.Angle = angle;
    }

    public Double getSize() {
        return Size;
    }

    public void setSize(Double size) {
        this.Size = size;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        this.MimeType = mimeType;
    }

    public String getPreviewUrl() {
        return PreviewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.PreviewUrl = previewUrl;
    }

    public Date getUploadTime() {
        return UploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.UploadTime = uploadTime;
    }
}

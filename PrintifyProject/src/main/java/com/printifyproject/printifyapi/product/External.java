package com.printifyproject.printifyapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class External {
    @JsonProperty("id")
    private String ExternalKey;

    @JsonProperty("handle")
    private String Handle;

    @JsonProperty("shipping_template_id")
    private String ShippingTemplateId;

    public String getExternalKey() {
        return ExternalKey;
    }

    public void setExternalKey(String externalKey) {
        this.ExternalKey = externalKey;
    }

    public String getHandle() {
        return Handle;
    }

    public void setHandle(String handle) {
        this.Handle = handle;
    }

    public String getShippingTemplateId() {
        return ShippingTemplateId;
    }

    public void setShippingTemplateId(String shippingTemplateId) {
        this.ShippingTemplateId = shippingTemplateId;
    }
}


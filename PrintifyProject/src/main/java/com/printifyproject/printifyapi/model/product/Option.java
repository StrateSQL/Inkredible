package com.printifyproject.printifyapi.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Option {
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("values")
    private List<OptionValue> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OptionValue> getValues() {
        return values;
    }

    public void setValues(List<OptionValue> values) {
        this.values = values;
    }
}

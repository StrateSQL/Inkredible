package com.printifyproject.printifyapi.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Shipping {
    @JsonProperty("handling_time")
    private HandlingTime HandlingTime = new HandlingTime();

    @JsonProperty("profiles")
    private List<Profile> Profiles = new ArrayList<>();

    public Shipping() {
    }

    public HandlingTime getHandlingTime() {
        return HandlingTime;
    }

    public void setHandlingTime(HandlingTime handlingTime) {
        this.HandlingTime = handlingTime;
    }

    public List<Profile> getProfiles() {
        return Profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.Profiles = profiles;
    }
}

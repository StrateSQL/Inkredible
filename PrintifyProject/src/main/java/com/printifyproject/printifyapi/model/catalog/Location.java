package com.printifyproject.printifyapi.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;

public class Location {
    @JsonProperty("address1")
    private String Address1 = "";

    @JsonProperty("address2")
    private String Address2;

    @JsonProperty("city")
    private String City = "";

    @JsonProperty("company")
    private String Company;

    @JsonProperty("country")
    private String Country = "";

    @Email
    @JsonProperty("email")
    private String Email;

    @JsonProperty("first_name")
    private String FirstName;

    @JsonProperty("last_name")
    private String LastName;

    @JsonProperty("phone")
    private String Phone;

    @JsonProperty("region")
    private String Region = "";

    @JsonProperty("zip")
    private String Zip = "";

    String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        this.Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        this.Address2 = address2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        this.Region = region;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        this.Zip = zip;
    }
}

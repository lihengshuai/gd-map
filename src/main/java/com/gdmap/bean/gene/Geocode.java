
package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formatted_address",
    "province",
    "citycode",
    "city",
    "district",
    "township",
    "neighborhood",
    "building",
    "adcode",
    "street",
    "number",
    "location",
    "level"
})
public class Geocode {

    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("province")
    private String province;
    @JsonProperty("citycode")
    private String citycode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("district")
    private List<Object> district = null;
    @JsonProperty("township")
    private List<Object> township = null;
    @JsonProperty("neighborhood")
    private Neighborhood neighborhood;
    @JsonProperty("building")
    private Building building;
    @JsonProperty("adcode")
    private String adcode;
    @JsonProperty("street")
    private List<Object> street = null;
    @JsonProperty("number")
    private List<Object> number = null;
    @JsonProperty("location")
    private String location;
    @JsonProperty("level")
    private String level;

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geocode withFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
        return this;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    public Geocode withProvince(String province) {
        this.province = province;
        return this;
    }

    @JsonProperty("citycode")
    public String getCitycode() {
        return citycode;
    }

    @JsonProperty("citycode")
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public Geocode withCitycode(String citycode) {
        this.citycode = citycode;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Geocode withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("district")
    public List<Object> getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(List<Object> district) {
        this.district = district;
    }

    public Geocode withDistrict(List<Object> district) {
        this.district = district;
        return this;
    }

    @JsonProperty("township")
    public List<Object> getTownship() {
        return township;
    }

    @JsonProperty("township")
    public void setTownship(List<Object> township) {
        this.township = township;
    }

    public Geocode withTownship(List<Object> township) {
        this.township = township;
        return this;
    }

    @JsonProperty("neighborhood")
    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    @JsonProperty("neighborhood")
    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Geocode withNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    @JsonProperty("building")
    public Building getBuilding() {
        return building;
    }

    @JsonProperty("building")
    public void setBuilding(Building building) {
        this.building = building;
    }

    public Geocode withBuilding(Building building) {
        this.building = building;
        return this;
    }

    @JsonProperty("adcode")
    public String getAdcode() {
        return adcode;
    }

    @JsonProperty("adcode")
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public Geocode withAdcode(String adcode) {
        this.adcode = adcode;
        return this;
    }

    @JsonProperty("street")
    public List<Object> getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(List<Object> street) {
        this.street = street;
    }

    public Geocode withStreet(List<Object> street) {
        this.street = street;
        return this;
    }

    @JsonProperty("number")
    public List<Object> getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(List<Object> number) {
        this.number = number;
    }

    public Geocode withNumber(List<Object> number) {
        this.number = number;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public Geocode withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    public Geocode withLevel(String level) {
        this.level = level;
        return this;
    }

}


package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country",
    "province",
    "city",
    "citycode",
    "district",
    "adcode",
    "township",
    "towncode",
    "neighborhood",
    "building",
    "streetNumber",
    "businessAreas"
})
public class AddressComponent {

    @JsonProperty("country")
    private String country;
    @JsonProperty("province")
    private String province;
    @JsonProperty("city")
    private List<Object> city = null;
    @JsonProperty("citycode")
    private String citycode;
    @JsonProperty("district")
    private String district;
    @JsonProperty("adcode")
    private String adcode;
    @JsonProperty("township")
    private String township;
    @JsonProperty("towncode")
    private String towncode;
    @JsonProperty("neighborhood")
    private Neighborhood neighborhood;
    @JsonProperty("building")
    private Building building;
    @JsonProperty("streetNumber")
    private StreetNumber streetNumber;
    @JsonProperty("businessAreas")
    private List<BusinessArea> businessAreas = null;

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public AddressComponent withCountry(String country) {
        this.country = country;
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

    public AddressComponent withProvince(String province) {
        this.province = province;
        return this;
    }

    @JsonProperty("city")
    public List<Object> getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(List<Object> city) {
        this.city = city;
    }

    public AddressComponent withCity(List<Object> city) {
        this.city = city;
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

    public AddressComponent withCitycode(String citycode) {
        this.citycode = citycode;
        return this;
    }

    @JsonProperty("district")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(String district) {
        this.district = district;
    }

    public AddressComponent withDistrict(String district) {
        this.district = district;
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

    public AddressComponent withAdcode(String adcode) {
        this.adcode = adcode;
        return this;
    }

    @JsonProperty("township")
    public String getTownship() {
        return township;
    }

    @JsonProperty("township")
    public void setTownship(String township) {
        this.township = township;
    }

    public AddressComponent withTownship(String township) {
        this.township = township;
        return this;
    }

    @JsonProperty("towncode")
    public String getTowncode() {
        return towncode;
    }

    @JsonProperty("towncode")
    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    public AddressComponent withTowncode(String towncode) {
        this.towncode = towncode;
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

    public AddressComponent withNeighborhood(Neighborhood neighborhood) {
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

    public AddressComponent withBuilding(Building building) {
        this.building = building;
        return this;
    }

    @JsonProperty("streetNumber")
    public StreetNumber getStreetNumber() {
        return streetNumber;
    }

    @JsonProperty("streetNumber")
    public void setStreetNumber(StreetNumber streetNumber) {
        this.streetNumber = streetNumber;
    }

    public AddressComponent withStreetNumber(StreetNumber streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    @JsonProperty("businessAreas")
    public List<BusinessArea> getBusinessAreas() {
        return businessAreas;
    }

    @JsonProperty("businessAreas")
    public void setBusinessAreas(List<BusinessArea> businessAreas) {
        this.businessAreas = businessAreas;
    }

    public AddressComponent withBusinessAreas(List<BusinessArea> businessAreas) {
        this.businessAreas = businessAreas;
        return this;
    }

}

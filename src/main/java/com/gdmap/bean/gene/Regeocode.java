
package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formatted_address",
    "addressComponent",
    "pois",
    "roads",
    "roadinters",
    "aois"
})
public class Regeocode {

    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("addressComponent")
    private AddressComponent addressComponent;
    @JsonProperty("pois")
    private List<Poi> pois = null;
    @JsonProperty("roads")
    private List<Road> roads = null;
    @JsonProperty("roadinters")
    private List<Roadinter> roadinters = null;
    @JsonProperty("aois")
    private List<Aoi> aois = null;

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Regeocode withFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
        return this;
    }

    @JsonProperty("addressComponent")
    public AddressComponent getAddressComponent() {
        return addressComponent;
    }

    @JsonProperty("addressComponent")
    public void setAddressComponent(AddressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }

    public Regeocode withAddressComponent(AddressComponent addressComponent) {
        this.addressComponent = addressComponent;
        return this;
    }

    @JsonProperty("pois")
    public List<Poi> getPois() {
        return pois;
    }

    @JsonProperty("pois")
    public void setPois(List<Poi> pois) {
        this.pois = pois;
    }

    public Regeocode withPois(List<Poi> pois) {
        this.pois = pois;
        return this;
    }

    @JsonProperty("roads")
    public List<Road> getRoads() {
        return roads;
    }

    @JsonProperty("roads")
    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public Regeocode withRoads(List<Road> roads) {
        this.roads = roads;
        return this;
    }

    @JsonProperty("roadinters")
    public List<Roadinter> getRoadinters() {
        return roadinters;
    }

    @JsonProperty("roadinters")
    public void setRoadinters(List<Roadinter> roadinters) {
        this.roadinters = roadinters;
    }

    public Regeocode withRoadinters(List<Roadinter> roadinters) {
        this.roadinters = roadinters;
        return this;
    }

    @JsonProperty("aois")
    public List<Aoi> getAois() {
        return aois;
    }

    @JsonProperty("aois")
    public void setAois(List<Aoi> aois) {
        this.aois = aois;
    }

    public Regeocode withAois(List<Aoi> aois) {
        this.aois = aois;
        return this;
    }

}

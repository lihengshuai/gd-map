
package com.gdmap.bean.gene;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "adcode",
    "location",
    "area",
    "distance",
    "type"
})
public class Aoi {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("adcode")
    private String adcode;
    @JsonProperty("location")
    private String location;
    @JsonProperty("area")
    private String area;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Aoi withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Aoi withName(String name) {
        this.name = name;
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

    public Aoi withAdcode(String adcode) {
        this.adcode = adcode;
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

    public Aoi withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(String area) {
        this.area = area;
    }

    public Aoi withArea(String area) {
        this.area = area;
        return this;
    }

    @JsonProperty("distance")
    public String getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Aoi withDistance(String distance) {
        this.distance = distance;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Aoi withType(String type) {
        this.type = type;
        return this;
    }

}

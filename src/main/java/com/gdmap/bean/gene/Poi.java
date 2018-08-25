
package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "type",
    "tel",
    "direction",
    "distance",
    "location",
    "address",
    "poiweight",
    "businessarea"
})
public class Poi {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tel")
    private List<Object> tel = null;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("location")
    private String location;
    @JsonProperty("address")
    private String address;
    @JsonProperty("poiweight")
    private String poiweight;
    @JsonProperty("businessarea")
    private String businessarea;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Poi withId(String id) {
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

    public Poi withName(String name) {
        this.name = name;
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

    public Poi withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("tel")
    public List<Object> getTel() {
        return tel;
    }

    @JsonProperty("tel")
    public void setTel(List<Object> tel) {
        this.tel = tel;
    }

    public Poi withTel(List<Object> tel) {
        this.tel = tel;
        return this;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Poi withDirection(String direction) {
        this.direction = direction;
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

    public Poi withDistance(String distance) {
        this.distance = distance;
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

    public Poi withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Poi withAddress(String address) {
        this.address = address;
        return this;
    }

    @JsonProperty("poiweight")
    public String getPoiweight() {
        return poiweight;
    }

    @JsonProperty("poiweight")
    public void setPoiweight(String poiweight) {
        this.poiweight = poiweight;
    }

    public Poi withPoiweight(String poiweight) {
        this.poiweight = poiweight;
        return this;
    }

    @JsonProperty("businessarea")
    public String getBusinessarea() {
        return businessarea;
    }

    @JsonProperty("businessarea")
    public void setBusinessarea(String businessarea) {
        this.businessarea = businessarea;
    }

    public Poi withBusinessarea(String businessarea) {
        this.businessarea = businessarea;
        return this;
    }

}

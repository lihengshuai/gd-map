
package com.gdmap.bean.gene;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "direction",
    "distance",
    "location",
    "first_id",
    "first_name",
    "second_id",
    "second_name"
})
public class Roadinter {

    @JsonProperty("direction")
    private String direction;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("location")
    private String location;
    @JsonProperty("first_id")
    private String firstId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("second_id")
    private String secondId;
    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Roadinter withDirection(String direction) {
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

    public Roadinter withDistance(String distance) {
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

    public Roadinter withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("first_id")
    public String getFirstId() {
        return firstId;
    }

    @JsonProperty("first_id")
    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    public Roadinter withFirstId(String firstId) {
        this.firstId = firstId;
        return this;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Roadinter withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("second_id")
    public String getSecondId() {
        return secondId;
    }

    @JsonProperty("second_id")
    public void setSecondId(String secondId) {
        this.secondId = secondId;
    }

    public Roadinter withSecondId(String secondId) {
        this.secondId = secondId;
        return this;
    }

    @JsonProperty("second_name")
    public String getSecondName() {
        return secondName;
    }

    @JsonProperty("second_name")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Roadinter withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

}

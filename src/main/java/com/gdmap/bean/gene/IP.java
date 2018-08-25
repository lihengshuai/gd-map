
package com.gdmap.bean.gene;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "info",
    "infocode",
    "province",
    "city",
    "adcode",
    "rectangle"
})
public class IP {

    @JsonProperty("status")
    private String status;
    @JsonProperty("info")
    private String info;
    @JsonProperty("infocode")
    private String infocode;
    @JsonProperty("province")
    private String province;
    @JsonProperty("city")
    private String city;
    @JsonProperty("adcode")
    private String adcode;
    @JsonProperty("rectangle")
    private String rectangle;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public IP withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("info")
    public String getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(String info) {
        this.info = info;
    }

    public IP withInfo(String info) {
        this.info = info;
        return this;
    }

    @JsonProperty("infocode")
    public String getInfocode() {
        return infocode;
    }

    @JsonProperty("infocode")
    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public IP withInfocode(String infocode) {
        this.infocode = infocode;
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

    public IP withProvince(String province) {
        this.province = province;
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

    public IP withCity(String city) {
        this.city = city;
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

    public IP withAdcode(String adcode) {
        this.adcode = adcode;
        return this;
    }

    @JsonProperty("rectangle")
    public String getRectangle() {
        return rectangle;
    }

    @JsonProperty("rectangle")
    public void setRectangle(String rectangle) {
        this.rectangle = rectangle;
    }

    public IP withRectangle(String rectangle) {
        this.rectangle = rectangle;
        return this;
    }

}

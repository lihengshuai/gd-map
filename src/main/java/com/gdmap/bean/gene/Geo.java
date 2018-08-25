
package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "info",
    "infocode",
    "count",
    "geocodes"
})
public class Geo {

    @JsonProperty("status")
    private String status;
    @JsonProperty("info")
    private String info;
    @JsonProperty("infocode")
    private String infocode;
    @JsonProperty("count")
    private String count;
    @JsonProperty("geocodes")
    private List<Geocode> geocodes = null;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Geo withStatus(String status) {
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

    public Geo withInfo(String info) {
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

    public Geo withInfocode(String infocode) {
        this.infocode = infocode;
        return this;
    }

    @JsonProperty("count")
    public String getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(String count) {
        this.count = count;
    }

    public Geo withCount(String count) {
        this.count = count;
        return this;
    }

    @JsonProperty("geocodes")
    public List<Geocode> getGeocodes() {
        return geocodes;
    }

    @JsonProperty("geocodes")
    public void setGeocodes(List<Geocode> geocodes) {
        this.geocodes = geocodes;
    }

    public Geo withGeocodes(List<Geocode> geocodes) {
        this.geocodes = geocodes;
        return this;
    }

}

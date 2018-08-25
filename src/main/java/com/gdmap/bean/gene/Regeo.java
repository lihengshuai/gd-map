
package com.gdmap.bean.gene;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "info",
    "infocode",
    "regeocode"
})
public class Regeo {

    @JsonProperty("status")
    private String status;
    @JsonProperty("info")
    private String info;
    @JsonProperty("infocode")
    private String infocode;
    @JsonProperty("regeocode")
    private Regeocode regeocode;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Regeo withStatus(String status) {
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

    public Regeo withInfo(String info) {
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

    public Regeo withInfocode(String infocode) {
        this.infocode = infocode;
        return this;
    }

    @JsonProperty("regeocode")
    public Regeocode getRegeocode() {
        return regeocode;
    }

    @JsonProperty("regeocode")
    public void setRegeocode(Regeocode regeocode) {
        this.regeocode = regeocode;
    }

    public Regeo withRegeocode(Regeocode regeocode) {
        this.regeocode = regeocode;
        return this;
    }

}

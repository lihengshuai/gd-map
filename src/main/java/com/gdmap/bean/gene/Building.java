
package com.gdmap.bean.gene;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "type"
})
public class Building {

    @JsonProperty("name")
    private List<Object> name = null;
    @JsonProperty("type")
    private List<Object> type = null;

    @JsonProperty("name")
    public List<Object> getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(List<Object> name) {
        this.name = name;
    }

    public Building withName(List<Object> name) {
        this.name = name;
        return this;
    }

    @JsonProperty("type")
    public List<Object> getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(List<Object> type) {
        this.type = type;
    }

    public Building withType(List<Object> type) {
        this.type = type;
        return this;
    }

}

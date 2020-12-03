package com.example.snsspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;




@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    @JsonProperty("protocol")
    private Protocol protocol;

    @JsonProperty("endPoint")
    private String endPoint;


    public Subscription(Protocol protocol, String endPoint) {
        this.protocol = protocol;
        this.endPoint = endPoint;
    }

}

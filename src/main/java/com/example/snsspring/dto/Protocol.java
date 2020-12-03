package com.example.snsspring.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;



public enum Protocol {

    EMAIL("email") ,
    SMS("sms"),
    SQS("sqs");

    @JsonProperty("name")
    public String name;

    private Protocol(@Valid  String value){
        this.name =value;
    }

    public String getName() {
        return name;
    }

}

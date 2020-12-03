package com.example.snsspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;




@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("message")
    private List<String> message;


    public Notification(String subject, List<String> message) {
        this.subject = subject;
        this.message = message;
    }


    public String getMessage(){
        StringBuilder sb = new StringBuilder();
        message.stream().forEach(c->sb.append(c + "\n"));
        return sb.toString();
    }

}

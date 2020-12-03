package com.example.snsspring.api;


import com.example.snsspring.dto.Notification;
import com.example.snsspring.dto.Subscription;
import com.example.snsspring.services.SNSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;





@RestController
@RequestMapping(value = "/v1/sns")
public class SNSController {


    private static final Logger logger = LoggerFactory.getLogger(SNSController.class);
    private SNSService snsService;


    @Autowired
    public SNSController(SNSService snsService) {
        this.snsService = snsService;
    }


    @PostMapping(value="/subscribe")
    public ResponseEntity subscribe(@Valid @RequestBody Subscription subscription) {
        try {
            String subsctiptionResult = snsService.subscribeToTopic(subscription);
            logger.info("Subscription has been added successfully");
            return new ResponseEntity(subsctiptionResult, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Subscription has been Failed to be added",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping(value="/notification")
    public ResponseEntity sendNotification(@RequestBody Notification notification) {
        try {
            String publishResult = snsService.sendNotification(notification);
            logger.info("Notification has been sent successfully");
            return new ResponseEntity(publishResult, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Notification has been failed to be sent",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}

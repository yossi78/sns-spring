package com.example.snsspring.services;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.example.snsspring.dto.Notification;
import com.example.snsspring.dto.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class SNSService {


    @Value("${cloud.aws.sns.email.topicARN}")
    private String TOPIC_ARN;

    private static final Logger logger = LoggerFactory.getLogger(SNSService.class);
    private AmazonSNSClient snsClient;



    @Autowired
    public SNSService(AmazonSNSClient snsClient) {
        this.snsClient = snsClient;
    }



    public String subscribeToTopic(Subscription subscription)  {
        logger.info("Subsribe: " + subscription);
        SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN,subscription.getProtocol().getName(),subscription.getEndPoint());
        SubscribeResult subscribeResult = snsClient.subscribe(subscribeRequest);
        return subscribeResult.toString();
    }


    public String sendNotification(Notification notification) {
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,notification.getMessage(),notification.getSubject());
        logger.info("Publish message: \nsubject: "+notification.getSubject() + "\n" +"message:\n"+notification.getMessage());
        PublishResult publishResult = snsClient.publish(publishRequest);
        return publishResult.toString();
    }
}

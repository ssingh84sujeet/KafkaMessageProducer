package com.sujit.KafkaMessageProducer.service;

import com.sujit.KafkaMessageProducer.dto.PaymentProcessing;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentProducetService {

   // @Value("${KafkaMessageProducer.producer.topic.name}")
    //private String topicName;

    @Autowired
    private KafkaTemplate template;



    public String doTransaction(PaymentProcessing processing) {
        template.send("test", processing);
        return "Payment Request has been initiated...";
    }


}

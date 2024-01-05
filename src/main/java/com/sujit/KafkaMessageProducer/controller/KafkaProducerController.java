package com.sujit.KafkaMessageProducer.controller;

import com.sujit.KafkaMessageProducer.dto.PaymentProcessing;
import com.sujit.KafkaMessageProducer.service.PaymentProducetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/publish")
public class KafkaProducerController {

    PaymentProducetService service;
    @Autowired
    public KafkaProducerController(PaymentProducetService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMoney(@RequestBody PaymentProcessing processing){
        processing.setTransactionId(UUID.randomUUID().toString());
        processing.setDate(new Date());
        String msg= service.doTransaction(processing);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }
}

package com.cg.api.apkafkagw.controller;

import com.cg.api.apkafkagw.model.OrderMeta;
import com.cg.api.apkafkagw.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestParam("message") String message) {
        this.producerService.sendMessage(message);
    }

    @PostMapping(value = "/createOrder")
    public void sendMessageToKafkaTopic(@RequestBody OrderMeta orderMeta){
        try {
            this.producerService.saveOrderLog(orderMeta);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

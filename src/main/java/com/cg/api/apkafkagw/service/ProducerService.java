package com.cg.api.apkafkagw.service;

import com.cg.api.apkafkagw.constant.AppConstants;
import com.cg.api.apkafkagw.model.OrderMeta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void sendMessage(String message) {
        logger.info(String.format("Message sent to Kafka -> %s", message));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_MESSAGE, message);
    }

    public void saveOrderLog(OrderMeta orderMeta) throws JsonProcessingException {
        logger.info(String.format("Order sent to Kafka -> %s", orderMeta));
        String value = objectMapper.writeValueAsString(orderMeta);
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_ORDER_LOG, String.valueOf(orderMeta.getOrderId()), value);
    }

}

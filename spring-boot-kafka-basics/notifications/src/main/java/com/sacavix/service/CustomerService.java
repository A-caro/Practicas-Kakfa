package com.sacavix.service;


import com.sacavix.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerService {

    @KafkaListener(topics = "${topic.customer.name:customers}",
            containerFactory = "kafkaListenerContainerFactory", groupId = "grupo1") //va a recibir el mensaje del productor

    public void consumer(Customer customer){
        if (customer.getClass().isAssignableFrom(Customer.class)){
            log.info("El objeto recibido es {} ", customer);
        }

    }
}

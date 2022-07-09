package com.sacavix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sacavix.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private KafkaTemplate<String,  Customer> producer;

	@Value("${topic.customer.name:customers}") //el topico se va a llamar customers
	private String topicCustomer;

	public Customer save(Customer customer){
		producer.send(topicCustomer, customer);
	return customer;
	}

}

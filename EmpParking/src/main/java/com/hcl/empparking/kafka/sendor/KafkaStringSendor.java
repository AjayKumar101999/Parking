package com.hcl.empparking.kafka.sendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringSendor {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	String topic="fruits";
	
	
	public void send(String message) {
		kafkaTemplate.send(topic, message);
	}
}

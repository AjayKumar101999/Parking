package com.hcl.empparking.kafka.reader;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaStringReader {

	@KafkaListener(topics = "fruits")
	public void stringConsume(String message) {
		log.info(message);
	}
}

package com.hcl.empparking.kafka.reader;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.empparking.dto.Allotment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaReader {

//	@KafkaListener(topics = "emp-allotment", groupId="group_id")
//	public void consume() {
//		try {
//			Properties props = new Properties();
//			props.put("bootstrap.servers", "localhost:9092");
//			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//			props.put("group.id", "group_id");
//			KafkaConsumer<String, Allotment> kafkaConsumer = new KafkaConsumer<>(props);
//			kafkaConsumer.subscribe(Collections.singletonList("emp-allotment"));
//
//			while (true) {
//				ConsumerRecords<String, Allotment> messages = kafkaConsumer.poll(10);
//				for (ConsumerRecord<String, Allotment> message : messages) {
//					log.info("message received " + message.value().toString());
//				}
//			}
//		
//	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	@KafkaListener(topics = "emp-allotment", groupId="group_id")
	public void consume(ConsumerRecord<String, Allotment> message) throws JsonProcessingException {
		log.info("msg consumed" + message);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		node = mapper.readTree(message.value().toString());
		String allotment = mapper.writeValueAsString(node);
		Allotment value = mapper.readValue(allotment, Allotment.class);
		log.info("bill dto : " + value);
		
//		
//		try {
//			billService.saveBill(newBill);
//		} catch (Exception e) {
//			log.error("Bill details not saved into the database :" + e.getMessage());
//		}

	}
}

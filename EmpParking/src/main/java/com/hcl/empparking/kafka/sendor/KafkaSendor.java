package com.hcl.empparking.kafka.sendor;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.hcl.empparking.entity.Allotment;
import com.hcl.empparking.kafka.serializer.KafkaJsonSerializer;

@Service
public class KafkaSendor {

	public void send(Allotment allotment) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		Producer<String, Allotment> kafkaProducer = new KafkaProducer<>(props, new StringSerializer(),
				new KafkaJsonSerializer());
		kafkaProducer.send(new ProducerRecord<>("emp-allotment", allotment));

	}
}
 
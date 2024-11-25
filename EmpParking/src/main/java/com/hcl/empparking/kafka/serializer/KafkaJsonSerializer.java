package com.hcl.empparking.kafka.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class KafkaJsonSerializer implements Serializer {

	@Override
	public void configure(Map map, boolean b) {

	}

	@Override
	public byte[] serialize(String s, Object o) {
		byte[] retval = null;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		try {
			retval = objectMapper.writeValueAsBytes(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retval;
	}

	@Override
	public void close() {

	}

}

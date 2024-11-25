package com.hcl.empparking.kafka.deserializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;


public class KafkaJsonDeSerializer<T> implements Deserializer {

	private Class<T> type;

	public KafkaJsonDeSerializer(Class type) {
		this.type = type;
	}

	@Override
	public void configure(Map map, boolean b) {

	}

	@Override
	public Object deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
	
		T obj = null;
		try {
			obj = mapper.readValue(data, type);
		} catch (Exception e) {
			
		}
		return obj;
	}

	@Override
	public void close() {

	}

}

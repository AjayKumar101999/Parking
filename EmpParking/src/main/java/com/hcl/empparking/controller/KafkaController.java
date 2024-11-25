package com.hcl.empparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.empparking.kafka.sendor.KafkaStringSendor;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kakfa")
@RequiredArgsConstructor
public class KafkaController {
	
	private final KafkaStringSendor kafkaStringSendor;

	@GetMapping("/send/{msg}")
	public String testKafka(@PathVariable String msg) {
		kafkaStringSendor.send(msg);
		return "message sent";
	}
}

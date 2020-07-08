package com.kafka.example.consumer.utils;

/**
 * Relevant properties for Apache Kafka configuration
 *
 */
public enum KafkaConstant {
	
	TOPIC_NAME("myTopicName"),GROUP_ID_CONFIG("consumerGroup"), BOOTSTRAP_SERVER("localhost:9092"),CLIENT_ID_CONFIG("client1");
	
	private String property;
	
	private KafkaConstant(String property) {
		this.property=property;
	}
	
	public String getProperty() {
		return property;
	}
}

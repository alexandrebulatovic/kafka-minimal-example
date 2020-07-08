package com.kafka.example.consumer;

import java.time.Duration;
import java.util.Collections;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.kafka.example.consumer.utils.KafkaConstant;
import com.kafka.example.consumer.utils.PropertiesProvider;

public class KafkaExampleApplicationConsumer {
	public static void main(String[] args) {

		System.out.println("Hello");
		Consumer<Long, String> consumer = new KafkaConsumer<>(PropertiesProvider.getConsumerProperties());
		consumer.subscribe(Collections.singletonList(KafkaConstant.TOPIC_NAME.getProperty()));


		Duration duration = Duration.ofSeconds(1L);
		int fetchAttempts = 0;

		while (true) {
			final ConsumerRecords<Long, String> consumerRecords = consumer.poll(duration);

			if (consumerRecords.isEmpty()) {
				fetchAttempts++;

				//we stop the consumer after 60 seconds of inactivity 
				if (fetchAttempts > 60) {
					System.out.println("Consumer stopped after 60 seconds.");
					break;
				}
			}

			consumerRecords.forEach(record -> System.out.println("Retrieved value: " +  record.value()));	

			fetchAttempts = 0;
			consumer.commitAsync();
		}

		consumer.close();
	}
}
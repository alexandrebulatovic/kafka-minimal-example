package com.kafka.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.kafka.example.producer.utils.KafkaConstant;
import com.kafka.example.producer.utils.PropertiesProvider;
/**
 * The program will send 100 messages to the Kafka topic and then will exit.
 *
 */
public class KafkaExampleApplicationProducer {
	public static void main(String[] args) {
		
		Producer<Long, String> producer = new KafkaProducer<>(PropertiesProvider.getProducerProperties());

		for (int i = 0; i < 100; i++) {

			String value = "msg no " + i;
			final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(KafkaConstant.TOPIC_NAME.getProperty(), value);

			try {

				RecordMetadata metadata = producer.send(record).get();

				System.out.println("Sent data : " + value);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		producer.close();
	}
}
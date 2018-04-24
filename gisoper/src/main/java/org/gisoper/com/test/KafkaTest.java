package org.gisoper.com.test;

public class KafkaTest {
    public static void main(String[] args) {
        UserKafkaProducer producerThread=new UserKafkaProducer(KafkaProperties.topic);
        producerThread.start();
        UserKafkaConsumer consumerThread=new UserKafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}

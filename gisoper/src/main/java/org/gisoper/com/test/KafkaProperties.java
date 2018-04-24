package org.gisoper.com.test;

public interface KafkaProperties {
    final static String zkConnect = "172.16.31.101:2181";
    final static String groupId="test-consumer-group";
    final static String topic ="topic1";
    final static String mytopic="mykafka";
    final static String kafkaServerURL = "192.168.139.128";
    final static int kafkaServerPort = 9093;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}

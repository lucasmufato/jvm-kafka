package ar.com.mufato.sensors.consumer;

import ar.com.mufato.sensors.producer.ProducerExample;
import ar.com.mufato.sensors.producer.infrastructure.PropertiesReader;
import org.apache.kafka.clients.consumer.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerExample {

  public static void main(final String[] args) throws Exception {

    final String topic = "iot-events";

    String configFile = "src/main/resources/app.properties";
    final Properties props = new PropertiesReader().loadConfig(configFile);

    // Add additional properties.
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-java-getting-started");
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    try (final Consumer<String, String> consumer = new KafkaConsumer<>(props)) {
      consumer.subscribe(Arrays.asList(topic));
      while (true) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, String> record : records) {
          //String key = record.key();
          String value = record.value();
          System.out.println(
//              String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));
              String.format("Consumed event from topic %s: value = %s", topic, value));
        }
      }
    }
  }

}

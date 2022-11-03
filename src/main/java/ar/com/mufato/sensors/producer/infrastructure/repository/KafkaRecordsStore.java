package ar.com.mufato.sensors.producer.infrastructure.repository;

import ar.com.mufato.sensors.producer.core.domain.SensorRecord;
import ar.com.mufato.sensors.producer.core.repository.RecordsStore;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaRecordsStore implements RecordsStore {

  private final Producer<String, String> producer;
  private final String topic;

  public KafkaRecordsStore(Producer<String, String> producer, String topic) {
    this.producer = producer;
    this.topic = topic;
  }

  @Override
  public void store(SensorRecord record) {
    String item = record.valueAsString();
    System.out.println("Sending> "+item);
    producer.send(
        new ProducerRecord<>(topic, item)
    );
    producer.flush();
    System.out.println("Item sent!");
  }

}
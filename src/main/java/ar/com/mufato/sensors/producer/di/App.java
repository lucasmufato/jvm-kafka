package ar.com.mufato.sensors.producer.di;

import ar.com.mufato.sensors.producer.core.actions.Sense10Records;
import ar.com.mufato.sensors.producer.core.repository.AirSensor;
import ar.com.mufato.sensors.producer.core.repository.RecordsStore;
import ar.com.mufato.sensors.producer.core.repository.Sensor;
import ar.com.mufato.sensors.producer.infrastructure.PropertiesReader;
import ar.com.mufato.sensors.producer.infrastructure.repository.KafkaRecordsStore;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

public class App {

  private final PropertiesReader propertiesReader = new PropertiesReader();
  private final Properties properties = propertiesReader.loadConfig("src/main/resources/app.properties");
  private final Producer<String, String> kafkaProducer = new KafkaProducer<>(properties);
  private final String topic = "iot-events";
  private final RecordsStore recordsStore = new KafkaRecordsStore(kafkaProducer,topic);
  private final List<Sensor> sensors = List.of(new AirSensor());

  private final Sense10Records sense10Records = new Sense10Records(sensors, recordsStore);

  public void start(){
    sense10Records.invoke();
  }

}

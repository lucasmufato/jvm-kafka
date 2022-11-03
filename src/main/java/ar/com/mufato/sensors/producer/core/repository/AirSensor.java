package ar.com.mufato.sensors.producer.core.repository;

import ar.com.mufato.sensors.producer.core.domain.AirRecord;
import ar.com.mufato.sensors.producer.core.domain.SensorRecord;
import java.util.Random;

public class AirSensor implements Sensor {

  private final String sensorName = "Living-room";
  private final Random random = new Random();

  @Override
  public SensorRecord getActualRecord() {
    return new AirRecord(sensorName, "Air", random.nextInt(100,500), random.nextInt(1,99));
  }

}

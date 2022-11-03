package ar.com.mufato.sensors.producer.core.domain;

public class AirRecord extends SensorRecord {

  private final Integer co2;
  private final Integer humidity;
  public AirRecord(String sensorName, String type, Integer co2, Integer humidity) {
    super(sensorName, type);
    this.co2 = co2;
    this.humidity = humidity;
  }

  @Override
  public String valueAsString() {
    return "name:%s|type:%s|co2:%d|humidity:%d".formatted(sensorName, type, co2, humidity);
  }
}

package ar.com.mufato.sensors.producer.core.domain;


public abstract class SensorRecord {

  protected final String sensorName;
  protected final String type;

  public SensorRecord(String sensorName, String type) {
    this.sensorName = sensorName;
    this.type = type;
  }

  public abstract String valueAsString();

}

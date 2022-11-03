package ar.com.mufato.sensors.producer.core.repository;

import ar.com.mufato.sensors.producer.core.domain.SensorRecord;

public interface Sensor {

  SensorRecord getActualRecord();
}

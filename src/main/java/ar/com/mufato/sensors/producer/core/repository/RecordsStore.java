package ar.com.mufato.sensors.producer.core.repository;

import ar.com.mufato.sensors.producer.core.domain.SensorRecord;

public interface RecordsStore {
  void store(SensorRecord record);
}

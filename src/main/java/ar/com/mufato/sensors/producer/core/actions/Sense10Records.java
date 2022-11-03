package ar.com.mufato.sensors.producer.core.actions;

import ar.com.mufato.sensors.producer.core.domain.SensorRecord;
import ar.com.mufato.sensors.producer.core.repository.RecordsStore;
import ar.com.mufato.sensors.producer.core.repository.Sensor;
import java.util.List;

public class Sense10Records {
  private final List<Sensor> sensors;
  private final RecordsStore recordsStore;


  public Sense10Records(List<Sensor> sensors, RecordsStore recordsStore) {
    this.sensors = sensors;
    this.recordsStore = recordsStore;
  }

  public void invoke(){
    for (int i = 0; i < 10; i++) {
      sensors.forEach(sensor -> {
        SensorRecord record = sensor.getActualRecord();
        recordsStore.store(record);
      });
    }
  }

}

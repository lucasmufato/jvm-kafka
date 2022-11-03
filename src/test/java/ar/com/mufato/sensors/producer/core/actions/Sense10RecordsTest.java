package ar.com.mufato.sensors.producer.core.actions;


import ar.com.mufato.sensors.producer.core.domain.SensorRecord;
import ar.com.mufato.sensors.producer.core.repository.RecordsStore;
import ar.com.mufato.sensors.producer.core.repository.Sensor;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Sense10RecordsTest {

  private Sense10Records sense10Records;

  private RecordsStore recordsStore = Mockito.mock(RecordsStore.class);

  @Test
  void retrievesData10Times() {
    Sensor fakeSensor = Mockito.mock(Sensor.class);
    List<Sensor> sensorsList = List.of(fakeSensor);
    sense10Records = new Sense10Records(sensorsList, recordsStore);

    sense10Records.invoke();

    Mockito.verify(fakeSensor, Mockito.times(10)).getActualRecord();
  }

  @Test
  void retrievesData10TimesForAllSensors() {
    //given
    Sensor fakeSensor = Mockito.mock(Sensor.class);
    Sensor otherFakeSensor = Mockito.mock(Sensor.class);
    List<Sensor> sensorsList = List.of(fakeSensor, otherFakeSensor);
    sense10Records = new Sense10Records(sensorsList, recordsStore);

    //when
    sense10Records.invoke();

    //then
    Mockito.verify(fakeSensor, Mockito.times(10)).getActualRecord();
    Mockito.verify(otherFakeSensor, Mockito.times(10)).getActualRecord();
  }

  @Test
  void storesRecords() {
    Sensor fakeSensor = Mockito.mock(Sensor.class);
    SensorRecord fakeSensorRecord = Mockito.mock(SensorRecord.class);
    Mockito.when(fakeSensor.getActualRecord()).thenReturn(fakeSensorRecord);

    List<Sensor> sensorsList = List.of(fakeSensor);
    sense10Records = new Sense10Records(sensorsList, recordsStore);

    //when
    sense10Records.invoke();

    Mockito.verify(recordsStore, Mockito.times(10)).store(fakeSensorRecord);
  }

}


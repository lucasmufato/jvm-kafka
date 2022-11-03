package ar.com.mufato.sensors.producer.infrastructure;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
  public Properties loadConfig(final String configFile) {
    final Properties cfg = new Properties();
    try (InputStream inputStream = new FileInputStream(configFile)) {
      cfg.load(inputStream);
    }catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
    return cfg;
  }

}

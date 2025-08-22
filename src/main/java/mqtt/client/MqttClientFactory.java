package mqtt.client;

import mqtt.core.BeanMqttClientConfig;
import mqtt.core.MqttClientImpl;

public class MqttClientFactory {

  public static MqttClientImpl bootstrap(String host, int port)
      throws InterruptedException {
    BeanMqttClientConfig config = new BeanMqttClientConfig();
    MqttClientImpl impl = new MqttClientImpl(config);

    impl.bootstrap(host, port);
    return impl;
  }

}

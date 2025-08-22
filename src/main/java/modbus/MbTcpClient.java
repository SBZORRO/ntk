package modbus;

import tcp.client.ConnectionListener;
import tcp.client.ITcpReader;
import tcp.client.InitializerFactory.MyReaderInitializer;
import tcp.client.NettyClient;
import tcp.client.TcpClient;

public class MbTcpClient {

  public static void main(String[] args) {}

  public static TcpClient connect(String ip, int port, ITcpReader reader)
      throws InterruptedException {
    NettyClient client = new TcpClient(ip, port)
        .listeners(new ConnectionListener())
        .init(new MyReaderInitializer(reader));
    return (TcpClient) NettyClient.bootstrap(client);
  }
}

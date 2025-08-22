package com.sbzorro;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import mqtt.client.MqttClientFactory;
import mqtt.core.MqttClientImpl;
import tcp.client.InitializerFactory.MyReaderInitializer;

public class App {

  public static final ExecutorService exe = Executors.newFixedThreadPool(100);

  public static void main(String[] args) throws Exception {

    MqttClientImpl SUBER = MqttClientFactory.bootstrap("127.0.0.1", 1883);
    SUBER.on("test", (t, b) -> {
      System.out.println(t);
    });

//    EventLoopGroup group = new NioEventLoopGroup(1);
//    Bootstrap bootstrap = new Bootstrap();
//    bootstrap.group(group)
//        .remoteAddress(InetSocketAddress.createUnresolved("127.0.0.1", 1883))
//        .channel(NioSocketChannel.class)
//        .handler(new LoggingHandler(LogLevel.WARN))
//        .handler(new MyReaderInitializer(bootstrap, ba -> {}));

//    ServerBootstrap bootstrap = new ServerBootstrap();
//    bootstrap.group(bossGroup(), singleGroup());
//    bootstrap.channel(NioServerSocketChannel.class);
//    bootstrap.option(ChannelOption.SO_BACKLOG, 100);
//    bootstrap.handler(new LoggingHandler(LogLevel.INFO));
//    bootstrap.childHandler(init());

//    future = bootstrap.bind(ip, port);
//    listen();

//    return future;

  }
}

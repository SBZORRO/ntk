package tcp.client;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

public class ConnectionListener implements ChannelFutureListener {

  Bootstrap bootstrap;

  public ConnectionListener(Bootstrap bootstrap) {
    this.bootstrap = bootstrap;
  }

  @Override
  public void operationComplete(ChannelFuture future) throws Exception {
    if (!future.isSuccess()) {
      final EventLoop loop = future.channel().eventLoop();
      loop.schedule(() -> bootstrap.connect().addListener(this), 5L,
          TimeUnit.SECONDS);
    } else {
      future.removeListener(this);
    }
  }
}

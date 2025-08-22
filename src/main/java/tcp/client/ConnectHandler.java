package tcp.client;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;

public final class ConnectHandler extends ChannelInboundHandlerAdapter {

  Bootstrap bootstrap;

  ConnectHandler(Bootstrap bootstrap) {
    this.bootstrap = bootstrap;
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    super.channelInactive(ctx);

    final EventLoop loop = ctx.channel().eventLoop();
    loop.schedule(
        () -> bootstrap.connect()
            .addListener(new ConnectionListener(bootstrap)),
        5, TimeUnit.SECONDS);
  }
}

package tcp.client;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class RetransmissionHandler<T> {

  private ScheduledFuture<?> timer;
  private int interval = 0;
  private int attempt = 1;
  private int attemptMax = 0; // infi
  private Consumer<T> handler;
  private T originalMessage;
  private ScheduledExecutorService exe;

  public RetransmissionHandler(
      Consumer<T> handler, T msg, ScheduledExecutorService exe,
      int interval, int max) {
    this.interval = interval;
    this.attemptMax = max;
    this.exe = exe;
    this.handler = handler;
    this.originalMessage = msg;
  }

  public void start() {
    this.timer = exe.scheduleAtFixedRate(() -> {
      if (attemptMax != 0 && attempt++ > attemptMax) {
        this.stop();
      }
      handler.accept(originalMessage);
    }, 0, interval, TimeUnit.MILLISECONDS);
  }

  void stop() {
    if (this.timer != null && !this.timer.isDone()) {
      this.timer.cancel(true);
    }
  }
}

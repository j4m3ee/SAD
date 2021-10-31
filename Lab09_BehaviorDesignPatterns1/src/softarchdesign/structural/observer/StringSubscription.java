package softarchdesign.structural.observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    private final Flow.Subscriber<String> subscriber;
    private final ExecutorService executor;

    public StringSubscription(Flow.Subscriber<String> subscriber,
                        ExecutorService executor) {
        this.subscriber = subscriber;
        this.executor = executor;
    }

    @Override
    public synchronized void request(long n) {
        if (n < 0) {
            IllegalArgumentException ex = new IllegalArgumentException();
            executor.execute(() -> subscriber.onError(ex));
        }
    }

    @Override
    public synchronized void cancel() {}

    public void publish(String str) {
        executor.execute(() -> {
            subscriber.onNext(str);
        });
    }
}


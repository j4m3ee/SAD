package softarchdesign.structural.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;

public class StringPublisher implements Flow.Publisher<String> {

    private final ExecutorService executorService = ForkJoinPool.commonPool();
    private List<StringSubscription> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber, executorService);
        subscriptions.add(subscription);
        subscriber.onSubscribe(subscription);
    }

    public void publish(String pub) {
        for (StringSubscription stringSubscription : subscriptions) {
            if(stringSubscription.isSubscribe(pub))
                stringSubscription.publish(pub);
        }
    }
}

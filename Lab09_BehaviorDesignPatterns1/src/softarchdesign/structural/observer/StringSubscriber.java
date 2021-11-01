package softarchdesign.structural.observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

abstract public class StringSubscriber  implements Subscriber<String>{
    private Flow.Subscription subscription;
    private String filename = "";

    public StringSubscriber(String subscribe) {
        try {
            this.filename = subscribe;
            File file = new File(subscribe + ".txt");
            if(file.createNewFile()) {
                System.out.println("File created : " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract boolean process(String str);

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String item){
         try {
             Writer file = new FileWriter(filename + ".txt", true);
             file.write(item + "\n");
             file.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Subscribe Error : " + throwable.toString());
    }

    @Override
    public void onComplete() {
        System.out.println("Subscribe complete!");
    }
}

package softarchdesign.structural.observer;

import java.util.Scanner;
import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Use \"exit()\" to stop.");
        Scanner input = new Scanner(System.in);
        String str = "";

        StringPublisher publisher = new StringPublisher();
        Flow.Subscriber<String> sub1 = new NumberSubscriber();
        Flow.Subscriber<String> sub2 = new SymbolSubscriber();
        Flow.Subscriber<String> sub3 = new AlphabetSubscriber();

        publisher.subscribe(sub1);
        publisher.subscribe(sub2);
        publisher.subscribe(sub3);

        while (true) {
            System.out.print("Enter text : ");
            str = input.nextLine();
            if (str.equals("exit()")) {
                break;
            }
            publisher.publish(str);
            System.out.println("Text input : " + str);
        }
        input.close();

        if(str.equals("exit()"))
            System.exit(0);


    }
}

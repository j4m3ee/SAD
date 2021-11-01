package softarchdesign.structural.observer;

import java.util.Scanner;
import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Use \"exit()\" to exit.");
        Scanner input = new Scanner(System.in);
        String str = "";

        StringPublisher publisher = new StringPublisher();
        StringSubscriber subNumber = new NumberSubscriber();
        StringSubscriber subSymbol = new SymbolSubscriber();
        StringSubscriber subAlphabet = new AlphabetSubscriber();

        publisher.subscribe(subNumber);
        publisher.subscribe(subSymbol);
        publisher.subscribe(subAlphabet);

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

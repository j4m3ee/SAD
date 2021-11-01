package softarchdesign.structural.observer;

public class NumberSubscriber extends StringSubscriber{

    public NumberSubscriber() {
        super("Number");
    }

    @Override
    public boolean process(String str) {
        return str.matches(".*[0-9].*");
    }

}

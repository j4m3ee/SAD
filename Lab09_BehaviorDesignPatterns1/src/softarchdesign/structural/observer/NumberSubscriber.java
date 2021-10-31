package softarchdesign.structural.observer;

public class NumberSubscriber extends StringSubscriber{

    public NumberSubscriber() {
        super("Number");
    }

    @Override
    public String process(String str) {
        if(str.matches(".*[0-9].*")) return str  + "\n";
        return "";
    }

}

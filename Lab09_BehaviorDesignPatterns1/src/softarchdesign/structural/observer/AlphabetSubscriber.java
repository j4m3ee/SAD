package softarchdesign.structural.observer;

public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber() { super("Alphabet"); }

    @Override
    public boolean process(String str) {
        return str.matches(".*[a-zA-Z].*");
    }
}

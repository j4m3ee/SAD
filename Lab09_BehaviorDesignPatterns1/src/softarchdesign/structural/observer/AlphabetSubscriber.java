package softarchdesign.structural.observer;

public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber() {
        super("Alphabet");
    }

    @Override
    public String process(String str) {
        if(str.matches(".*[a-zA-Z].*"))
        {
            return str + "\n";
        }
        return "";
    }
}

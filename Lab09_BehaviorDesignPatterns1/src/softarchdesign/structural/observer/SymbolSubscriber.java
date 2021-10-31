package softarchdesign.structural.observer;

public class SymbolSubscriber extends StringSubscriber {

    public SymbolSubscriber() {
        super("Symbol");
    }

    @Override
    public String process(String str) {
        if(!str.matches("[a-zA-Z0-9.]*")) return str + "\n";
        return "";
    }
}

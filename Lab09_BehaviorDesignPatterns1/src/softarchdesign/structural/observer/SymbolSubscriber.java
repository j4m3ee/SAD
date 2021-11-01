package softarchdesign.structural.observer;

public class SymbolSubscriber extends StringSubscriber {

    public SymbolSubscriber() {
        super("Symbol");
    }

    @Override
    public boolean process(String str) {
        return !str.matches("[a-zA-Z0-9.]*");
    }
}

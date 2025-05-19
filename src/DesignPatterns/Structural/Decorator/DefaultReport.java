package DesignPatterns.Structural.Decorator;

public class DefaultReport implements Report {

    private String text;

    public DefaultReport(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

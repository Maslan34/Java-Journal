package DesignPatterns.Behavioural.Mediator;

public enum VEGATABLES {

    TOMATO("tomato"),
    CUCUMBER("cucumber");

    String vegatableName;

    VEGATABLES(String vegatableName) {
        this.vegatableName = vegatableName;
    }

    public String getVegatableName() {
        return vegatableName;
    }

    public void setVegatableName(String vegatableName) {
        this.vegatableName = vegatableName;
    }
}

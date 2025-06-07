package DesignPatterns.Behavioural.Command;

public enum OperatorKind {
    SUM("SUM"),
    DIVIDE("DIVIDE"),
    SUBSTRCUTION("SUBSTRCUTION"),
    MULTIPLY("MULTIPLY");

    String kind;

    OperatorKind(String kind) {
        this.kind = kind;
    }
}

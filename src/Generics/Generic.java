package Generics;

public class Generic <M> {


    private M value;

    public Generic(M value) {
        this.value = value;
    }

    public M getValue() {
        return value;
    }

    public void setValue(M value) {
        this.value = value;
    }
}

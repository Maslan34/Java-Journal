package DesignPatterns.State;

public class BrushTool implements Tool {

    @Override
    public void mouseDown() {
        System.out.println("BrushTool Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw Line");
    }
}

package DesignPatterns.State;

public class Canvas {
    private Tool currentTool;

    public void MouseDown(){
        currentTool.mouseDown();
    }

    public void MouseUp(){
        currentTool.mouseUp();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }


    // Open Closed Principle ->open for extension closed for modification.
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.MouseDown();
        canvas.MouseUp();
        canvas.setCurrentTool(new SelectionTool());
        canvas.MouseDown();
        canvas.MouseUp();
    }
}

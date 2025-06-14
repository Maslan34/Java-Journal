package DesignPatterns.Behavioural.Memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states =new ArrayList<EditorState>();

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        return states.remove(states.size()-1);
    }
}

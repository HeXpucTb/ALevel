package console_editor;

import java.util.Stack;

public class ComandHistory {
    private Stack<Command> history = new Stack<>();
    private Stack<Command> historyUn = new Stack<>();
    public void push(Command c){
        history.push(c);
    }
    public Command pop(){
        return history.pop();
    }
    public boolean isEmpty(){
        return history.isEmpty();
    }
    public Command popUn(){
        return historyUn.pop();
    }
    public boolean isEmptyUn(){
        return historyUn.isEmpty();
    }
    public void pushUn(Command command){
        historyUn.push(command);
    }
}

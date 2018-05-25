package console_editor;

import java.util.ArrayList;
import java.util.Scanner;

public class Editor {
    private ArrayList<String> text = new ArrayList<>();
    private ComandHistory history = new ComandHistory();

    public void init(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String str;
        Editor editor = this;
        TalkUtils.showUserMessage();
        do{
            str = sc.nextLine();
            switch (str){
                case "save": {
                    executeCommand(new SaveToFileCommand(editor));
                    break;
                }
                case "undo": undo(); break;
                case "redo": redo(); break;
                case "exit": exit = true;
                default: text.add(str);
            }

        }while (!exit);
    }

    private void executeCommand(Command command){
        if(command.execute()){
            history.push(command);
        }
    }
    private void undo(){
        if(!history.isEmpty()) {
            Command command = history.pop();
            if(command!=null){
                history.pushUn(command);
                command.undo();
            }
        }
    }
    private void redo(){
        if(!history.isEmptyUn()){
            Command command = history.popUn();
            if(command!=null){
                history.push(command);
                command.redo();
            }
        }
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void clearText(){
        this.text.clear();
    }
}

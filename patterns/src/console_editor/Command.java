package console_editor;

public abstract class Command {
    Editor editor;
    Command(Editor editor){
        this.editor = editor;
    }
    public abstract void undo();
    public abstract void redo();
    public abstract boolean execute();

}

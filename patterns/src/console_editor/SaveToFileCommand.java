package console_editor;

import java.util.ArrayList;

public class SaveToFileCommand extends Command {
    private int addedStringsCount;
    private ArrayList<String> currentText;

    SaveToFileCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        currentText = new ArrayList<>(editor.getText());
        addedStringsCount = currentText.size();
        if(FileUtils.isFileExists()){
            if(TalkUtils.askUpdateFile()){
                FileUtils.updateDataAtFile(currentText);
            }else {
                FileUtils.saveDataToFile(currentText);
            }
        }else {
            FileUtils.saveDataToFile(currentText);
        }
        editor.clearText();
        return true;
    }

    @Override
    public void undo() {
        ArrayList<String> clipboard = FileUtils.getDataFromFile();
        FileUtils.saveDataToFile(cutUpdatedText(clipboard, addedStringsCount));
    }

    @Override
    public void redo() {
        FileUtils.updateDataAtFile(currentText);
    }
    private ArrayList<String> cutUpdatedText(ArrayList<String> textFromFile, int size){
        ArrayList<String> resultText = new ArrayList<>();
        for (int i = 0; i < textFromFile.size() - size; i++) {
            resultText.add(textFromFile.get(i));
        }
        return resultText;
    }
}

package console_editor;

import java.util.Scanner;

public abstract class TalkUtils {
    private static final String APP_NAME = "Text Editor";
    private static final String SAVE_TEXT = "Enter 'save' for saving text into a file;";
    private static final String UNDO_TEXT = "Enter 'undo' for reject last updates;";
    private static final String REDO_TEXT = "Enter 'redo' for repeat last updates;";
    private static final String EXIT_TEXT = "Enter 'exit' for exit;";
    private static final String START_TEXT = "Enter text:";
    private static final String UPDATE_FILE_TEXT = "The file is exist, will update or rewrite?(u/r)";

    private static Scanner sc = new Scanner(System.in);
    public static boolean askUpdateFile(){
        System.out.println(UPDATE_FILE_TEXT);
        return sc.nextLine().equals("u");
    }
    public static void showUserMessage(){
        System.out.println(APP_NAME);
        System.out.println(SAVE_TEXT);
        System.out.println(UNDO_TEXT);
        System.out.println(REDO_TEXT);
        System.out.println(EXIT_TEXT);
        System.out.println(START_TEXT);
    }
}

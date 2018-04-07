import java.util.Scanner;

public class PingPong {
    private static boolean end = false;
    public static void main(String[] args) {
        PingPongPC pc = new PingPongPC();
        Thread pcThread = new Thread(pc);
        pcThread.start();
        while (!end){
            Scanner scanner = new Scanner(System.in);
            String check = scanner.next();
            if(!check.equals("")){
                pc.setLoose(false);
            }
            if(!pcThread.isAlive()){
                end = true;
            }
        }
    }
}

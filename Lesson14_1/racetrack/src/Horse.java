import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{
    private CyclicBarrier cb;
    private String horseName;
    private int number;
    private int distance = 1000;
    private Random random = new Random();
    private long finishTime;
    private Thread thread;

    public Horse (int number, String name, CyclicBarrier cb){
        this.number = number;
        horseName = name;
        this.cb = cb;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public long getFinishTime(){
        return finishTime;
    }

    public String getHorseName() {
        return horseName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        boolean finish = false;
        System.out.println(horseName+" has started!");
        do{
            distance -= getPassedDistance();
            if(distance<1){
                finish = true;
            }
            try {
                Thread.sleep(getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!finish);
        System.out.println(horseName+" got FINISH!");
        finishTime = System.currentTimeMillis();
    }
    private int getPassedDistance(){
        return random.nextInt(20)+30;
    }
    private long getDelay(){
        return random.nextInt(100)+300;
    }
}


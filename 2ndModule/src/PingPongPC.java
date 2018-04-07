public class PingPongPC implements Runnable{
    private boolean loose = false;
    @Override
    public synchronized void run() {
        while (!loose){
            System.out.println("bamm");
            loose = true;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Loose");

    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }
}

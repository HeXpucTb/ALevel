import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {
    private static Scanner scanner = new Scanner(System.in);
    private static int threads;
    private static int startPoint;
    private static int endPoint;
    private static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) {
        initParameters();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        executor.submit(()->{
            int[] full = new int[endPoint];
            for (int i = startPoint; i < endPoint; i++) {
                full[i] = i;
                if(full[i] == 1){
                    full[i]=0;
                }
            }
            for (int j = 2; j < endPoint; j++){
                if(full[j]!=0) {
                    for (int k = j * 2; k < endPoint; k += j) {
                        full[k] = 0;
                    }
                }
            }
            for (int i: full) {
                if(i!=0) {
                    primes.add(i);
                }
            }
        });
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
        printPrimes();
    }
    private static void initParameters(){
        System.out.println("How much threads will we use?");
        threads = scanner.nextInt();
        System.out.println("Write start point:");
        startPoint = scanner.nextInt();
        System.out.println("Write end point:");
        endPoint = scanner.nextInt();
    }
    private static void printPrimes(){
        for (int i:primes) {
            System.out.print(" "+i);
        }
        System.out.println();
    }
}

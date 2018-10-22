import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ex21_3 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Print());
        }
        //Thread.yield();
        es.shutdown();

        es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(new Print());
        }
        //Thread.yield();
        es.shutdown();

        es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            es.execute(new Print());
        }
        //Thread.yield();
        es.shutdown();

    }
}

class Print implements Runnable{
    private static int taskCount;
    private final int id = taskCount++;
    Print(){
        System.out.println("Print started, ID = " + id);
    }
    @Override
    public void run() {
        System.out.println("Stage 1 ..... ID = " + id);
        Thread.yield();
        System.out.println("Stage 2 ..... ID = " + id);
        Thread.yield();
        System.out.println("Stage 3 ..... ID = " + id);
        Thread.yield();
    }
}
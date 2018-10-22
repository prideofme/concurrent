import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ex21_6{
    //private static Random rand = new Random(47);
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            //int time = rand.nextInt(10) + 1;
            es.execute(new time_test());
        }
        Thread.yield();
        es.shutdown();
    }
}

class time_test implements Runnable{
    private static Random rand = new Random();
    private static int time = rand.nextInt(10) + 1;;
    //public time_test(int time){this.time = time;}
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(time);
    }
}
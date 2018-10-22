import java.util.ArrayList;
import java.util.concurrent.*;

public class ex21_5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            result.add(es.submit(new FibonacciSum(i)));
        }
        //Thread.yield();
        es.shutdown();

        for (Future<Integer> r : result) {
            try{
                System.out.println(r.get());
            }catch (Exception e){
                throw (e);
            }
        }
    }
}

class FibonacciSum implements Callable{
    //private int count;
    private final int n;
    public FibonacciSum(int n){this.n = n;}
    public Integer next(int count){return fib(count);}
    private int fib(int b){
        if(b <= 2) return 1;
        return fib(b-2) + fib(b-1);
    }

    public Integer call(){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += next(i+1);
        }
        return sum;
    }

}
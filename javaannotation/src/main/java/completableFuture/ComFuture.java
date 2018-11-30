package completableFuture;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wufangyu
 */
public class ComFuture {
    private static Random random = new Random();

    public static void master() {
        CompletableFuture.runAsync(run1).thenRun(run2).thenRun(run3).join();
    }

    static Runnable run1 = () -> System.out.println("执行run1");

    static Runnable run2 = () -> System.out.println("执行run2");

    static Runnable run3 = () -> System.out.println("执行run3");

    Function<String, String> taskB = String::toUpperCase;

    /**
     * 创建线程池线程个数为4的线程池
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    static int delayRandom(int min, int max) {
        int mills = max > min ? random.nextInt(max - min) : 0;
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mills;
    }

    /**
     * 还可以构建Runnable 线程任务接口
     * 使用CompletableFuture 调用外部服务
     *
     * @return
     */
    public static Future<Integer> supplierCallService() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(extern, executorService);
        return integerCompletableFuture;
    }

    static Supplier<Integer> extern = () -> {
        int time = delayRandom(20, 2000);

        return time;
    };

    static void test() throws Exception {
        Future<Integer> submit = executorService.submit(exTask);
        submit.get();
    }

    static Callable<Integer> exTask = () -> {
        int time = delayRandom(20, 2000);
        return time;
    };

    static Runnable runnable = () -> {

    };

}

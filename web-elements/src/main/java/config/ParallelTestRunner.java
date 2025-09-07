package config;

import threads.runTestInThread;
import threads.runnableThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelTestRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int N = 5000; // час очікування в мілісекундах
/*        runTestInThread test1 = new runTestInThread(ConfigProvider.getDriver());
        runTestInThread test2 = new runTestInThread(ConfigProvider.getDriver());

        // запуск потоків
        test1.start();
        test2.start();

        Thread thread1 = new Thread(new runnableThread(ConfigProvider.getDriver()));
        Thread thread2 = new Thread(new runnableThread(ConfigProvider.getDriver()));

        thread1.start();
        thread2.start();*/

        //executorService для запуску тестів в паралельних потоках

        /*ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new runnableThread(ConfigProvider.getDriver()));
        executor.submit(new runnableThread(ConfigProvider.getDriver()));
        executor.shutdown();*/


        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> results = new ArrayList<>();
        int[] delays = {1, 2, 3, 1, 2};

        for (int i = 0; i < 5; i++) {
            int taskNumber = i + 1;
            int sleepMiliSeconds = delays[i];

            Callable<String> callable = () -> {
                System.out.println("Entered Callable");
                Thread.sleep(sleepMiliSeconds * 1000);
                return "Готово: Завдання №" + taskNumber + "з потоку " + Thread.currentThread().getName();
            };
            
            results.add(executor.submit(callable));
        }

        for (Future<String> future : results) {
                System.out.println("Result: " + future.get());
        }
        
        executor.shutdown();

    }
}
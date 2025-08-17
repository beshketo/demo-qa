package config;

import threads.runTestInThread;

public class ParallelTestRunner {
    public static void main(String[] args) {

        runTestInThread test1 = new runTestInThread(ConfigProvider.getDriver());
        runTestInThread test2 = new runTestInThread(ConfigProvider.getDriver());

        // запуск потоків
        test1.start();
        test2.start();
    }
}
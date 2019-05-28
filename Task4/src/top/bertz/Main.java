package top.bertz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger fail = new AtomicInteger();
        AtomicInteger count = new AtomicInteger();
        AtomicInteger success = new AtomicInteger();
        AtomicInteger request = new AtomicInteger();
        RequestLinkedBlockingDeque<Request> requests = new RequestLinkedBlockingDeque<>(20, fail);
        Producer producer1 = new Producer(count, success, fail, requests);
        Producer producer2 = new Producer(count, success, fail, requests);
        Producer producer3 = new Producer(count, success, fail, requests);
        Consumer consumer = new Consumer(requests, request);
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);
        Thread.sleep(10 * 1000);
        System.out.println("shutdowning");
        service.shutdownNow();
        System.out.println("shutdowned");
        int wait = request.get() - success.get() - fail.get();
        System.out.println("requests: " + request +" success: " + success + " fail :" + fail + " waiting: " + wait);
    }
}

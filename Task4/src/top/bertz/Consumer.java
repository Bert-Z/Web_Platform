package top.bertz;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

    private RequestLinkedBlockingDeque<Request> requests;
    private AtomicInteger request;

    public Consumer(RequestLinkedBlockingDeque<Request> requests, AtomicInteger request) {
        this.requests = requests;
        this.request = request;
    }


    @Override
    public void run() {
        try {
            while (true) {
                long timeout = 2000;
                if(this.requests.pushRequest(new Request(), timeout, TimeUnit.MILLISECONDS))
                {
                    System.out.println("add new Request success!");
                    this.request.incrementAndGet();
                }
                else{
                    System.out.println("add new Request failed!");
                }
                Thread.sleep(500);
            }
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            System.out.println("consumer thread quit safely, id:" + Thread.currentThread().getId());
        }
    }
}

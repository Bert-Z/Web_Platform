package top.bertz;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private AtomicInteger count;
    private AtomicInteger success;
    private AtomicInteger fail;
    private RequestLinkedBlockingDeque<Request> requests;

    public Producer(AtomicInteger count, AtomicInteger success, AtomicInteger fail, RequestLinkedBlockingDeque<Request> requests) {
        this.count = count;
        this.success = success;
        this.fail = fail;
        this.requests = requests;
    }


    @Override
    public void run() {
        System.out.println("Start producer thread-" + Thread.currentThread().getName());

        try {
            while (true) {
                // add the production count
                int need = (int) (Math.random() * 100) % 4 + 1;
                int count = this.count.addAndGet(need);
                System.out.println("Production now: " + count + " by" + Thread.currentThread().getName());

                System.out.println("Requests size: " + this.requests.size());
                try {
                    Request request = this.requests.popRequest();
                    if (request.getNum() <= this.count.get()) {
                        System.out.println("Request get " + request.getNum() + " has " + this.count);
                        this.count.updateAndGet(x -> (x - request.getNum()));
                        this.requests.remove(request);
                        System.out.println("Success");
                    } else {
                        System.out.println("Count last: " + this.count.get());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("Clean old request.");
                this.requests.removeOldRequest();
                System.out.println("Producer sleep 2s");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted.");
        }finally {
            System.out.println("Producer thread quit safely, id:" + Thread.currentThread().getName());
        }
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    public AtomicInteger getSuccess() {
        return success;
    }

    public void setSuccess(AtomicInteger success) {
        this.success = success;
    }

    public AtomicInteger getFail() {
        return fail;
    }

    public void setFail(AtomicInteger fail) {
        this.fail = fail;
    }

    public RequestLinkedBlockingDeque<Request> getRequests() {
        return requests;
    }

    public void setRequests(RequestLinkedBlockingDeque<Request> requests) {
        this.requests = requests;
    }
}

package top.bertz;

import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestLinkedBlockingDeque<E> extends LinkedBlockingDeque<E> {

    private AtomicInteger fail;

    public RequestLinkedBlockingDeque(int capacity, AtomicInteger fail) {
        super(capacity);
        this.fail = fail;
    }

    public Boolean pushRequest(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return this.offerLast(e, timeout, unit);
    }

    public E popRequest() {
        if (this.size() > 5) {
            // Using FILO
            System.out.println("FILO");
            try {
                return this.getLast();
            } catch (NoSuchElementException e) {
                System.out.println("No such request.");
                return null;
            }
        } else {
            // Using FIFO
            System.out.println("FIFO");
            try {
                return this.getFirst();
            } catch (NoSuchElementException e) {
                System.out.println("No such request.");
                return null;
            }
        }
    }

    public void removeOldRequest() {
        long now = System.currentTimeMillis();
        try {
            E request = this.getFirst();
            if (now - ((Request) request).getTime() >= 5000) {
                System.out.println("request " + request.hashCode() + " is out.");
                this.pollFirst();
                this.fail.incrementAndGet();
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("No old request");
        }
    }
}

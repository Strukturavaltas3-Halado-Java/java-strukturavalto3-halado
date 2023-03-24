package org.training360;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafe {


    private AtomicInteger count = new AtomicInteger(0);

    private synchronized void incrementAndReport(){
        System.out.println((count.incrementAndGet()));
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(20);
            ThreadSafe threadSafe = new ThreadSafe();

            for(int i=0;i<10;i++){
                service.submit(()->threadSafe.incrementAndReport());
            }
        }finally {
            service.shutdown();
        }
    }
}

package org.training360;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

//        new Thread(()-> System.out.println("Hello world2")).start();
//        new Thread(()-> System.out.println("Hello world 3")).start();
//        System.out.println("Hello world!");

        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(10);
            System.out.println("begin");
            service.submit(()->{
                for(int i=0;i<3;i++){
                    System.out.println("loop"+i);
                }
            });

            service.execute(()-> System.out.println("Info1"));
            service.execute(()-> System.out.println("Info2"));
            System.out.println("end");
        }finally {
            service.shutdown();
        }
    }
}
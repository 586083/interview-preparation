package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDesignPatternLazyLoadingTest {

    @Test
    public void SingletonDesignPatternLazyLoadingTest() {
        //This block of code will give error because private constructor will not allow to instantiate
        //SingletonDesignPatternLazyLoading obj1=new SingletonDesignPatternLazyLoading();

        //So to get the instance we need to use the static factor method;
        SingletonDesignPatternLazyLoading obj1=SingletonDesignPatternLazyLoading.getInstance();
        obj1.printDetails(5);
        System.out.println("Class loadedr for obj1"+obj1.getClass().getClassLoader());
        //second class loader
        SingletonDesignPatternLazyLoading obj2=SingletonDesignPatternLazyLoading.getInstance();
        obj2.printDetails(100);
        System.out.println("Class loader for obj2"+obj2.getClass().getClassLoader());
    }

    @Test
    public void SingletonDesignPatternLazyLoadingTest_MultiThread() throws InterruptedException {
        int numberOfThreads = 5;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            final int point = i + 1;
            executor.submit(() -> {
                SingletonDesignPatternLazyLoading singleton =
                        SingletonDesignPatternLazyLoading.getInstance();
                singleton.printDetails(point);
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
        System.out.println("Final counter-"+SingletonDesignPatternLazyLoading.getInstance().getCounter()+"-Thread-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId());
    }

}

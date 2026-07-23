package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ExtendWith(MockitoExtension.class)
public class SingletonDesignPatternEarlyInstantiationTest {

    @Test
    public void SingletonDesignPatternEarlyInstantiationTest() {
        //This block of code will give error because private constructor will not allow to instantiate
        //SingletonDesignPatternEarlyInstantiation obj1=new SingletonDesignPatternEarlyInstantiation();

        //So to get the instance we need to use the static factor method;
        SingletonDesignPatternEarlyInstantiation obj1=SingletonDesignPatternEarlyInstantiation.getInstance();
        obj1.printDetails(5);
        System.out.println("Class loadedr for obj1"+obj1.getClass().getClassLoader());
        //second class loader
        SingletonDesignPatternEarlyInstantiation obj2=SingletonDesignPatternEarlyInstantiation.getInstance();
        obj2.printDetails(100);
        System.out.println("Class loader for obj2"+obj2.getClass().getClassLoader());

    }

    /**
     * Singleton Design Pattern :: It allows to create only one instance for an class
     * Early Instantiation means creation of Singleton class instance at declaration time itself
     * Inside getInstance Thread details-pool-1-thread-1.35
     * Inside getInstance Thread details-pool-1-thread-4.38
     * Inside getInstance Thread details-pool-1-thread-2.36
     * Inside getInstance Thread details-pool-1-thread-3.37
     * Inside getInstance Thread details-pool-1-thread-5.39
     *
     *  Inside SingletonDesignPatternEarlyInstantiation::231909309-Point-4-counter-5-Thread-pool-1-thread-4.38
     *
     *  Inside SingletonDesignPatternEarlyInstantiation::231909309-Point-3-counter-10-Thread-pool-1-thread-3.37
     *
     *  Inside SingletonDesignPatternEarlyInstantiation::231909309-Point-1-counter-1-Thread-pool-1-thread-1.35
     *
     *  Inside SingletonDesignPatternEarlyInstantiation::231909309-Point-2-counter-7-Thread-pool-1-thread-2.36
     *
     *  Inside SingletonDesignPatternEarlyInstantiation::231909309-Point-5-counter-15-Thread-pool-1-thread-5.39
     * Inside getInstance Thread details-main.1
     * Final counter-15
     *  231909309 is same hascode , meaning always one object reference is given.
     *  but during multi thread env, based on thread execution, out put value differs
     *
     *  231909309-Point-1-counter-1-Thread-pool-1-thread-1.35 , Thread 1.35 enter, read counter which is zero, counter=0+1{point} , counter=1{counterValue}
     *  231909309-Point-4-counter-5-Thread-pool-1-thread-4.38 , Thread 4.38 enter, read counter which is 1, counter=1+4{point} , counter=5{counterValue}
     *  231909309-Point-2-counter-7-Thread-pool-1-thread-2.36 , Thread 2.36 enter, read counter which is 5, counter=5+2{point} , counter=7{counterValue}
     *  231909309-Point-3-counter-10-Thread-pool-1-thread-3.37, Thread 3.37 enter, read counter which is 7, counter=7+3{point} , counter=10{counterValue}
     *  231909309-Point-5-counter-15-Thread-pool-1-thread-5.39, Thread 5.39 enter, read counter which is 10, counter=10+5{point} , counter=15{counterValue}
     *
     *  why i except 5 is , but the exution of thread dependes upon the OS, but final operation result is same.
     *
     * iteration 1, i=0, point=1 goes to printDeatail 0+1=1
     * iteration 2, i=1, point=2 goes to printDeatail 1+2=3
     * iteration 3, i=2, point=3 goes to printDeatail 3+3=6
     * iteration 4, i=3, point=4 goes to printDeatail 6+4=10
     * iteration 5, i=4, point=5 goes to printDeatail 10+5=15
     *
     * incase of multi thread, this can happen, so make the variable volatile/ and addtion operation synchronized, or use Atomic Variable
     * counter = 10
     * Thread A read counter = 10
     * Thread B read counter = 10
     * Thread A performs 10 + 5 = 15 writes 15
     * Thread B perform 10 + 8 = 18 writes 18
     *  Expected is 23 but Actual is 18
     *
     * @throws InterruptedException
     */
    @Test
    public void SingletonDesignPatternEarlyInstantiationTest_MultiThread() throws InterruptedException {
        int numberOfThreads = 5;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            final int point = i + 1;
            executor.submit(() -> {
                SingletonDesignPatternEarlyInstantiation singleton =
                        SingletonDesignPatternEarlyInstantiation.getInstance();
                singleton.printDetails(point);
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
        System.out.println("Final counter-"+SingletonDesignPatternEarlyInstantiation.getInstance().getCounter());
    }


}

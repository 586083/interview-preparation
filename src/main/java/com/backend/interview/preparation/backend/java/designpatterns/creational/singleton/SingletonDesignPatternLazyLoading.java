package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonDesignPatternLazyLoading {

    //another static member
    private static AtomicInteger counter;

    private static volatile SingletonDesignPatternLazyLoading instance;

    private SingletonDesignPatternLazyLoading() {System.out.println("Singleton Design Pattern :: It allows to create only one instance for an class"
            +"\n"+ "Early Instantiation means creation of Singleton class instance at declaration time itself");}

    public static SingletonDesignPatternLazyLoading getInstance() {
        if(instance == null) {
            synchronized (SingletonDesignPatternLazyLoading.class) {
                if (instance == null) {
                    System.out.println("Inside getInstance Thread details-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId());
                    instance = new SingletonDesignPatternLazyLoading();
                }
            }
        }
        return instance;
    }

    public void printDetails(int addPoint) {
        counter.addAndGet(addPoint);
        System.out.println("\n Inside SingletonDesignPatternLazyLoading::"+instance.hashCode()+"-Point-"+addPoint+"-counter-"+counter.get()+"-Thread-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId());
    }
    public static int getCounter() {
        return counter.get();
    }
}

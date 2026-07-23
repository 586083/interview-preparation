package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;


import java.util.concurrent.atomic.AtomicInteger;

public class SingletonDesignPatternEarlyInstantiation {

    //another static member
    private static AtomicInteger counter;

    //static member to access the instance on Singleton Class
    private static SingletonDesignPatternEarlyInstantiation instance=new SingletonDesignPatternEarlyInstantiation();

    //private constructor to avoid instantiation of singleton class outside these class
    private SingletonDesignPatternEarlyInstantiation() {
        System.out.println("Singleton Design Pattern :: It allows to create only one instance for an class"
                +"\n"+ "Early Instantiation means creation of Singleton class instance at declaration time itself");
    }

    //static factory method to access the Singleton class instance
    public static SingletonDesignPatternEarlyInstantiation getInstance(){
        System.out.println("Inside getInstance Thread details-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId());
        return instance;
    }

    public void printDetails(int addPoint) {
        counter.addAndGet(addPoint);
        System.out.println("\n Inside SingletonDesignPatternEarlyInstantiation::"+instance.hashCode()+"-Point-"+addPoint+"-counter-"+counter.get()+"-Thread-"+Thread.currentThread().getName() + "." + Thread.currentThread().threadId());
    }

    public int getCounter() {
        return counter.get();
    }
}

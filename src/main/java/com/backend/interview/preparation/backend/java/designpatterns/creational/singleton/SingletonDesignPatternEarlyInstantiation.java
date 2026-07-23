package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;


public class SingletonDesignPatternEarlyInstantiation {

    //another static member
    private static int counter;

    //static member to access the instance on Singleton Class
    private static SingletonDesignPatternEarlyInstantiation instance=new SingletonDesignPatternEarlyInstantiation();

    //private constructor to avoid instantiation of singleton class outside these class
    private SingletonDesignPatternEarlyInstantiation() {
        System.out.println("Singleton Design Pattern :: It allows to create only one instance for an class"
                +"\n"+ "Early Instantiation means creation of Singleton class instance at declaration time itself");
    }

    //static factory method to access the Singleton class instance
    public static SingletonDesignPatternEarlyInstantiation getInstance(){
        return instance;
    }

    public void printDetails(int addPoint) {
        counter=counter+addPoint;
        System.out.println("\n Inside SingletonDesignPatternEarlyInstantiation::"+instance.hashCode()+"Point"+addPoint+"counter"+counter);
    }
}

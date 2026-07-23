package com.backend.interview.preparation.backend.java.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
}

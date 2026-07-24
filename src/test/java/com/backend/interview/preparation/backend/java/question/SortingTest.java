package com.backend.interview.preparation.backend.java.question;

import com.backend.interview.preparation.backend.java.interview.question.Sorting;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SortingTest {

    @Test
    public void sortMapTest() {
        Map<Integer, String> map = new HashMap();
        map.put(7, "Aara");
        map.put(31, "Yamni");
        map.put(35, "Aravinth");
        map.put(5, "Sai");
        System.out.println("Sorted Map By Key"+Sorting.sortMapByKey(map));
        System.out.println("Sorted Map By Value"+Sorting.sortMapByValues(map));
    }
}

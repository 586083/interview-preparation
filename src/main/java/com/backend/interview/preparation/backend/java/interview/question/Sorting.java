package com.backend.interview.preparation.backend.java.interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sorting {

    /**
     * Sort a map using streams with Map Key
     */
    public static Map<Integer, String> sortMapByKey(Map<Integer, String> inputMap) {
        if(inputMap == null) {
            return inputMap;
        }
        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
    }

    /**
     * Sort a map using streams with Map Values
     */
    public static Map<Integer, String> sortMapByValues(Map<Integer, String> inputMap) {
        if(inputMap == null) {
            return inputMap;
        }
        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
    }

}

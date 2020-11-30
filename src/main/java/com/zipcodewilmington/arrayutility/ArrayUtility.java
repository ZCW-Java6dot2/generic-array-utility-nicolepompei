package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<SomeType> {
    private SomeType[] inputArray;


    public ArrayUtility(SomeType[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(SomeType[] arrayToMerge, SomeType valueToEvaluate){
        List<SomeType> valueList = new ArrayList<>();
        valueList.addAll(Arrays.asList(arrayToMerge));
        valueList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(valueList, valueToEvaluate);
    }

    public SomeType[] removeValue(SomeType valueToRemove) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
        SomeType[] result = Arrays.copyOf(inputArray, inputArray.length -numberOfOccurrences);
        for (int i = 0, j =0; i < inputArray.length; i++) {
            if(inputArray[i] != valueToRemove){
                result[j] = inputArray[i];
                j++;
            }

        }
        return result;
    }

    public Integer getNumberOfOccurrences(SomeType valueToEvaluate) {
        List<SomeType>  valueList = new ArrayList<>();
        valueList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(valueList, valueToEvaluate);
    }

    public SomeType getMostCommonFromMerge(SomeType[] arrayToMerge) {
        Integer mostCommonCounter = Integer.MIN_VALUE;
        List<SomeType> valueList = new ArrayList<>();
        SomeType mostCommonValue = null;
        valueList.addAll(Arrays.asList(arrayToMerge));
        valueList.addAll(Arrays.asList(inputArray));
        for(SomeType value : valueList){
            Integer current = Collections.frequency(valueList, value);
            if(current > mostCommonCounter){
                mostCommonCounter = current;
                mostCommonValue = value;
            }

        }
        return mostCommonValue;
    }
}

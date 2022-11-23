package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <Object> {
    Object[] arrayUtilityArray;

    public ArrayUtility(Object[] inputArray) {
        arrayUtilityArray = inputArray;
    }

    public Object[] removeValue(Object valueToRemove) {
        for (int i=0; i<arrayUtilityArray.length-1; i++) {
            if (arrayUtilityArray[i].equals(valueToRemove)) {
                arrayUtilityArray[i] = arrayUtilityArray[i+1];
            }
        }
        return arrayUtilityArray;
    }

    public Integer getNumberOfOccurrences(Object valueToEvaluate) {
        Integer numberOfOccurrences = 0;
        for (int i=0; i<arrayUtilityArray.length; i++) {
            if (arrayUtilityArray[i].equals(valueToEvaluate)) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    public Object getMostCommonFromMerge(Object[] arrayToMerge) {
        Object mostCommon = null;
        Integer most = 0;
        Integer count = 0;
        ArrayList<Object> ao = new ArrayList<>(Arrays.asList(arrayUtilityArray));
        ao.addAll(Arrays.asList(arrayToMerge));
        for (Object o : ao) {
            for (Object p : ao) {
                if (o.equals(p)) count++;
            }
            if (count>most) {
                most = count;
                mostCommon = o;
            }
            count=0;
        }
        return mostCommon;
    }

    public Integer countDuplicatesInMerge(Object[] arrayToMerge, Object valueToEvaluate) {
        Integer count = 0;
        ArrayList<Object> ao = new ArrayList<>(Arrays.asList(arrayUtilityArray));
        ao.addAll(Arrays.asList(arrayToMerge));
        for (Object o : ao) {
            if (o.equals(valueToEvaluate)) count++;
        }
        return count;
    }
}

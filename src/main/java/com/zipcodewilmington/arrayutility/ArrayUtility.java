package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    T[] arrayUtilityArray;

    public ArrayUtility(T[] inputArray) {
        arrayUtilityArray = inputArray;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> al = new ArrayList<>();
        for (Object o : arrayUtilityArray) {
            if (!o.equals(valueToRemove)) {
                al.add((T) o);
            }
        }
        return toArray(al);
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

    public T getMostCommonFromMerge(Object[] arrayToMerge) {
        T mostCommon = null;
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
                mostCommon = (T) o;
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

    public T[] toArray(List<T> list) {
        T[] newArray = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
        for (int i=0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
}

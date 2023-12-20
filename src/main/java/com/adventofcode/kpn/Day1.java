package main.java.com.adventofcode.kpn;

import main.java.com.adventofcode.kpn.utilities.Utility;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String [] args){
        List<Integer> inputList = null;
        try {
            String url = "src/main/resources/day1.txt";
            inputList = Utility.readFromInputStream(url).stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Count the number of times a depth measurement increases from the previous measurement.");
        System.out.println("Count = " + countOfDeptMeasurementIncrease(inputList));
        System.out.println();
        System.out.println("Count the number of times the sum of measurements in this sliding window increases from the previous sum.");
        System.out.println("Count = " + countSlidingWindowMeasurementIncrease(inputList));
        System.out.println();

    }

    private static int countOfDeptMeasurementIncrease(List<Integer> inputList){
        int count = 0;
        int previousValue = inputList.get(0);
        for (int i=1; i<inputList.size(); i++) {
            if(previousValue<inputList.get(i)){
                count++;
            }
            previousValue = inputList.get(i);
        }
       return count;
    }

    private static int countSlidingWindowMeasurementIncrease(List<Integer> inputList){
        int count = 0;
        int previousSum = inputList.get(0) + inputList.get(1) + inputList.get(2);
        int currentSum = 0;
        for (int i=1; i<inputList.size()-2; i++) {
            currentSum = inputList.get(i) + inputList.get(i+1) + inputList.get(i+2);
            if(previousSum<currentSum){
                count++;
            }
            previousSum = currentSum;
        }
        return count;
    }


}

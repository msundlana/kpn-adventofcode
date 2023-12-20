package main.java.com.adventofcode.kpn;

import main.java.com.adventofcode.kpn.model.Binary;
import main.java.com.adventofcode.kpn.utilities.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {
    public static void main(String [] args){
        List<String> inputList = null;
        try {
            String url = "src/main/resources/day3.txt";
            inputList = Utility.readFromInputStream(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("What is the power consumption of the submarine?");
        System.out.println("Power consumption = " + calculatePowerConsumption(inputList));
        System.out.println();
        System.out.println("What is the life support rating of the submarine?");
        System.out.println("Life support rating = " + calculateLifeSupportRating(inputList));
    }

    private static Map<Integer, Binary> getBinaryCountMap(List<String> inputList){
        Map<Integer, Binary> map = new HashMap<>();
        for (String input: inputList) {
            for(int i=0; i<input.length(); i++){
                if(map.containsKey(i)){
                    int zeroCount = input.charAt(i)=='0'?map.get(i).getZeroCount()+1:map.get(i).getZeroCount();
                    int oneCount = input.charAt(i)=='1'?map.get(i).getOneCount()+1:map.get(i).getOneCount()+0;
                    map.get(i).setZeroCount(zeroCount);
                    map.get(i).setOneCount(oneCount);
                }else {
                    int zeroCount = input.charAt(i)=='0'?1:0;
                    int oneCount = input.charAt(i)=='1'?1:0;
                    map.put(i,new Binary(zeroCount,oneCount));
                }
            }
        }
        return map;
    }

    private static int calculatePowerConsumption(List<String> inputList){
        String gammaRate = "";
        String epsilonRate = "";

        for (Binary binary: getBinaryCountMap(inputList).values()) {
            if(binary.getZeroCount()>binary.getOneCount()){
                gammaRate +=0+"";
                epsilonRate +=1+"";
            }else{
                gammaRate +=1+"";
                epsilonRate +=0+"";
            }
        }
        System.out.println("gamma rate = " + gammaRate);
        System.out.println("epsilon rate = " +epsilonRate);
        return Integer.parseInt(gammaRate,2)*Integer.parseInt(epsilonRate,2);
    }


    private static int calculateLifeSupportRating(List<String> inputList) {
        return calculateOxygenGeneratorRating(inputList,0)*calculateCO2ScrubberRating(inputList,0);
    }

    private static int calculateOxygenGeneratorRating(List<String> inputList,Integer key){
        Binary binary = getBinaryCountMap(inputList).get(key);
        int commonBinary = binary.getZeroCount()>binary.getOneCount()?0:1;
        List<String> list = new ArrayList<>();

        for (String strNum : inputList) {
            if(Character.getNumericValue(strNum.charAt(key))==commonBinary){
                list.add(strNum);
            }

        }
        if(list.size()==1){
            System.out.println("oxygen generator rating = " + list.get(0));
            return Integer.parseInt(list.get(0),2);
        }else {
            return calculateOxygenGeneratorRating(list,key+1);
        }

    }

    private static int calculateCO2ScrubberRating(List<String> inputList,Integer key){
        Binary binary = getBinaryCountMap(inputList).get(key);
        int leastCommonBinary = binary.getZeroCount()<=binary.getOneCount()?0:1;
        List<String> list = new ArrayList<>();

        for (String strNum : inputList) {
            if(Character.getNumericValue(strNum.charAt(key))==leastCommonBinary){
                list.add(strNum);
            }

        }
        if(list.size()==1){
            System.out.println("CO2 scrubber rating= " + list.get(0));
            return Integer.parseInt(list.get(0),2);
        }else {
            return calculateCO2ScrubberRating(list,key+1);
        }

    }
}

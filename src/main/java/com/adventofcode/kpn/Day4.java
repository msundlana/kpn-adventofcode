package main.java.com.adventofcode.kpn;

import main.java.com.adventofcode.kpn.utilities.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String [] args){
        List<String> inputList = null;
        try {
            String url = "src/main/resources/day4.txt";
            inputList = Utility.readFromInputStream(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(getWinningScore(getDrawNumbers(inputList),getBoards(inputList)));
    }

    private static List<Integer> getDrawNumbers(List<String> inputList){
        return Arrays.stream(inputList.get(0).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static  List<List<String>>  getBoards(List<String> inputList){
        List<List<String>> boardsArrayList = new ArrayList<>();
        List<String> boardsArray = new ArrayList<>();
        for (int i=2; i<inputList.size(); i++){
            if(inputList.get(i).equals("")){
                boardsArray = new ArrayList<>();
            }else {
                if(boardsArray.size()==0){
                    boardsArrayList.add(boardsArray);
                }
                boardsArray.add(inputList.get(i));
            }
        }
        return boardsArrayList;
    }

    private static int getWinningScore(List<Integer> drawNumbers,List<List<String>> boardsList){
        List<List<String>> boardsListTemp = new ArrayList<>();
        System.out.println(boardsList.size());
        for(Integer drawNumber: drawNumbers){
            int i = 0;
            for(List<String> boards: boardsList){
                for(String str: boards){
                    if(str.contains(drawNumber+" ")){
                        System.out.println(str.replaceAll(drawNumber+" ",drawNumber+"* "));
                    }else if(str.contains(" "+drawNumber)){
                        System.out.println(str.replaceAll(" "+drawNumber," *"+drawNumber));
                    }else {
                        System.out.println(str);
                    }

                }
                System.out.println();
            }
            i++;
        }
        System.out.println(boardsList);
       return 0;
    }
}

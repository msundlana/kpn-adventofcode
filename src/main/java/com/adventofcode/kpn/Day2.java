package main.java.com.adventofcode.kpn;

import main.java.com.adventofcode.kpn.model.Position;
import main.java.com.adventofcode.kpn.utilities.Utility;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String [] args){
        List<Position> inputList = null;
        try {
            String url = "src/main/resources/day2.txt";
            inputList = Utility.readFromInputStream(url).stream().map(str->{
                String[] splitStr = str.split("\\s+");
                return new Position(splitStr[0],Integer.parseInt(splitStr[1]));
            }).collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("What do you get if you multiply your final horizontal position by your final depth?");
        System.out.println("Position = " + calculatePositionOfSubmarine(inputList));
        System.out.println();

    }

    private static int calculatePositionOfSubmarine(List<Position> inputList){
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (Position position: inputList) {
            if(position.getMove().equals("forward")){
                horizontal += position.getValue();
                depth += position.getValue() * aim;
            }else if(position.getMove().equals("down")){
                aim += position.getValue();
            }else if(position.getMove().equals("up")){
                aim -= position.getValue();
            }
        }
        return horizontal * depth;
    }
}

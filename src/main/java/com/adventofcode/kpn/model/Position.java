package main.java.com.adventofcode.kpn.model;

public class Position {
    String move;
    int value;

    public Position(String move, int value) {
        this.move = move;
        this.value = value;
    }

    public String getMove() {
        return move;
    }

    public int getValue() {
        return value;
    }
}

package main.java.com.adventofcode.kpn.model;

public class Binary {
    int zeroCount;
    int oneCount;

    public Binary(int zeroCount, int oneCount) {
        this.zeroCount = zeroCount;
        this.oneCount = oneCount;
    }

    public int getZeroCount() {
        return zeroCount;
    }

    public void setZeroCount(int zeroCount) {
        this.zeroCount = zeroCount;
    }

    public int getOneCount() {
        return oneCount;
    }

    public void setOneCount(int oneCount) {
        this.oneCount = oneCount;
    }
}

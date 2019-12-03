package model.operations;

import model.Node;

public class Subtraction implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Addition();
    }

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public boolean isSwiping(){
        return true;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getDefaultValue() {
        return "0";
    }
}

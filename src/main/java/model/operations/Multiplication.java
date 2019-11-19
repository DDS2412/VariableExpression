package model.operations;

import model.Node;

public class Multiplication implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Division();
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String getDefaultValue() {
        return "1";
    }

    @Override
    public String toString() {
        return "*";
    }
}

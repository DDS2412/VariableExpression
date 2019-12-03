package model.operations;

import model.Node;

public class Pow implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new SquarePow();
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
        return "^";
    }
}

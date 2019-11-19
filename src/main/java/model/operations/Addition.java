package model.operations;

import model.Node;

public class Addition implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Subtraction();
    }

    @Override
    public String toString() {
        return "+";
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

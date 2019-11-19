package model.operations;

import model.Node;

public class Division implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Multiplication();
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public String getDefaultValue() {
        return "1";
    }

    @Override
    public String toString() {
        return "/";
    }
}

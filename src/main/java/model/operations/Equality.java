package model.operations;

import model.Node;

public class Equality implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return null;
    }

    @Override
    public String toString() {
        return "=";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public String getDefaultValue() {
        return "0";
    }
}

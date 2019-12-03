package model.operations;

public class SquarePow implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Pow();
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
        return "^1/";
    }
}

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
    public Node expressNode(Node root, String variable) {
        return null;
    }
}

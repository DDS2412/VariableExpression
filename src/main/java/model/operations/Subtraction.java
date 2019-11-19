package model.operations;

import model.Node;

public class Subtraction implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Addition();
    }

    @Override
    public String getValue() {
        return "-";
    }

    @Override
    public Node expressNode(Node root, String variable) {
        return null;
    }
}

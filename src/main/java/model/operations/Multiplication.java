package model.operations;

import model.Node;

public class Multiplication implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Division();
    }

    @Override
    public Node expressNode(Node root, String variable) {
        return null;
    }

    @Override
    public String toString() {
        return "*";
    }
}

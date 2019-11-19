package model.operations;

import model.Node;

public class Division implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Multiplication();
    }

    @Override
    public Node expressNode(Node root, String variable) {
        return null;
    }

    @Override
    public String toString() {
        return "/";
    }
}

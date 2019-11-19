package model.operations;

import model.Node;

public class Addition implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Subtraction();
    }

    @Override
    public String getValue() {
        return "+";
    }

    @Override
    public Node expressNode(Node root, String variable) {
        return root;
    }
}
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
    public Node expressNode(Node root, String variable) {
        return root;
    }
}

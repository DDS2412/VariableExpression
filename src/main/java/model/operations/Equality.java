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
    public Node expressNode(Node root, String variable) {
        return root;
    }
}

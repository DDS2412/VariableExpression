package model.operations;

import model.Node;

public interface Operation {
    public Operation getOppositeOperation();
    public Node expressNode(Node root, String variable);
}

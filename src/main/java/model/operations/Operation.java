package model.operations;

import model.Node;

public interface Operation {
    public Operation getOppositeOperation();
    public String getValue();
    public Node expressNode(Node root, String variable);
}

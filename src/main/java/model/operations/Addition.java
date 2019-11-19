package model.operations;

import model.Node;

public class Addition implements Operation {
    @Override
    public Operation getOppositeOperation() {
        return new Subtraction();
    }

    @Override
    public Node expressNode(Node root, String variable) {
        Node left = root.left;
        Node right = root.right;
        Node result;

        if (left.contains(variable) && !right.contains(variable)){
            result = new Node(left.node)
        }
    }
}

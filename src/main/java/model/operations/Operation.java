package model.operations;

import model.Node;

public interface Operation {
    public Operation getOppositeOperation();
    public default Node expressNode(Node root, String variable){
        Node left = root.getLeft();
        Node right = root.getRight();
        Node result = null;

        if (left.hasVariable(variable)){
            Node expressedLeft = left.getOperation().expressNode(left,variable);
            if (right.hasVariable(variable)){
                Node expressedRight = right.getOperation().expressNode(left,variable);

            } else {
                if (expressedLeft == null){
                    root = left;

                    Node tmpNode = new Node();
                    tmpNode.setValue(this.getDefaultValue());

                    result = new Node();
                    result.setLeft(tmpNode);
                    result.setRight(right);
                    result.setOperation(this.getOppositeOperation());
                } else {

                }
            }
        } else {
            if (right.hasVariable(variable)){
                Node expressedRight = right.getOperation().expressNode(right,variable);
                if (expressedRight == null){
                    root = right;

                    Node tmpNode = new Node();
                    tmpNode.setValue(this.getDefaultValue());

                    result = new Node();
                    result.setLeft(tmpNode);
                    result.setRight(left);
                    result.setOperation(this.getOppositeOperation());
                }
            } else {
                return root;
            }
        }
        return null;
    }
    public int getOrder();
    public String getDefaultValue();
}

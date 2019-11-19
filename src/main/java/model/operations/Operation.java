package model.operations;

import model.Node;

public interface Operation {
    public Operation getOppositeOperation();
    public default Node[] expressNode(Node root, String variable){
//        Node left = root.getLeft();
//        Node right = root.getRight();
//
//        Node[] result = new Node[2];
//        result[0] = new Node();
//        result[1] = new Node();
//
//        if (left == null){
//            if (right == null){
//                if (root.getValue().equals(variable)){
//                    result[1] = root;
//                } else {
//                    result[0] = root;
//                }
//                return result;
//            } else {
//                Node[] expressedRightArray = right.getOperation().expressNode(right,variable);
//                Node expressedRight = expressedRightArray[0];
//                Node savedRight = expressedRightArray[1];
//                if (left.getValue().equals(variable)){
//                    result[0] = expressedRight.concatNodes()
//                }
//            }
//        }
//        Node[] expressedLeftArray = left.getOperation().expressNode(left,variable);
//        Node expressedLeft = expressedLeftArray[0];
//        Node savedLeft = expressedLeftArray[1];
//        Node[] expressedRightArray = right.getOperation().expressNode(right,variable);
//        Node expressedRight = expressedRightArray[0];
//        Node savedRight = expressedRightArray[1];
//
//        if (left.hasVariable(variable)){
//
//
//            if (right.hasVariable(variable)){
//
//
//                if (expressedLeft != null
//                        && expressedLeft.getOperation().getOrder() == root.getOperation().getOrder()){
//                    if (expressedRight != null
//                            && expressedRight.getOperation().getOrder() == root.getOperation().getOrder()){
//                        result[0] = new Node();
//                        result[0].setLeft(expressedLeft);
//                        result[0].setOperation(left.getOperation().getOppositeOperation());
//                        result[0] = result[0].concatNodes(result[0],expressedRight);
//                        result[1] = new Node();
//                        result[1].setLeft(savedLeft);
//                        result[1].setOperation(left.getOperation().getOppositeOperation());
//                        result[1] = result[1].concatNodes(result[1],savedRight);
//                    } else {
//                        result[0] = expressedLeft;
//                        result[1] = result[1].concatNodes(right,savedLeft);
//                    }
//                } else {
//                    if (expressedRight.getOperation().getOrder() == root.getOperation().getOrder()) {
//                        result[0] = expressedRight;
//                        result[1] = result[1].concatNodes(left,savedRight);
//                    } else {
//                        result[0] = null;
//                        result[1] = root;
//                    }
//                }
//
//
//            } else {
//                root = left;
//
//                Node tmpNode = new Node();
//                tmpNode.setValue(this.getDefaultValue());
//
//                result[0] = new Node();
//                result[0].setLeft(tmpNode);
//                result[0].setRight(right);
//                result[0].setOperation(this.getOppositeOperation());
//            }
//        } else {
//            if (right.hasVariable(variable)){
//                Node[] expressedRightArray = right.getOperation().expressNode(right,variable);
//                Node expressedRight = expressedRightArray[0];
//                Node savedRight = expressedRightArray[1];
//
//                if (expressedRight != null
//                        && expressedRight.getOperation().getOrder() == root.getOperation().getOrder()){
//                    ex
//                }
//
//            } else {
//                result[0] = root;
//                result[1] = null;
//            }
//        }
        return null;
    }
    public int getOrder();
    public String getDefaultValue();
}

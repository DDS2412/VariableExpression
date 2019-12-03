package services;

import model.Node;
import model.operations.Equality;
import model.operations.Operation;

public class ExpressionService {

    public  Node[] singleExpress(Node root, Node rightSide, String variable) {
        if (root == null || root.getValue() != null && root.getValue().equals(variable)) {
            return null;
        }

        if (!root.hasVariable(variable)) {
            return new Node[]{root, null};
        }

        if (root.getOperation() == null) {
            return new Node[]{null, root};
        }

        Node left = root.getLeft();
        Node right = root.getRight();

        Node expressedValue = new Node();
        Operation oppositeOperation = root.getOperation().getOppositeOperation();
        expressedValue.setLeft(null);
        if (left.hasVariable(variable)) {
            expressedValue.setOperation(oppositeOperation);
            expressedValue.setRight(right);
            return new Node[]{expressedValue, left};
        } else {
            if (root.getOperation().isSwiping()){
                expressedValue.setOperation(root.getOperation());
                expressedValue.setRight(rightSide);
                expressedValue.setLeft(left);
            } else {
                expressedValue.setOperation(oppositeOperation);
                expressedValue.setRight(left);
            }
            return new Node[]{expressedValue, right};
        }

    }

    public Node express(Node root, String variable){

        Node withVariable = root.getLeft();
        Node withoutVariable = root.getRight();

        Node result = withoutVariable;

        do {
            boolean isSwiping = withVariable.getOperation().isSwiping();

            Node[] expressionResult = this.singleExpress(withVariable,result,variable);
            withoutVariable = expressionResult[0];
            withVariable = expressionResult[1];

            if (isSwiping){
                result = withoutVariable;
            } else {
                Node tmpNode = new Node();
                tmpNode.setLeft(result);
                tmpNode.setRight(withoutVariable.getRight());
                tmpNode.setOperation(withoutVariable.getOperation());
                result = tmpNode;
            }

        } while( withVariable != null && !variable.equals(withVariable.getValue()));

        return new Node().setOperation(new Equality()).setRight(result).setLeft(new Node().setValue(variable));
    }
}

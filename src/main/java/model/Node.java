package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import model.operations.Operation;
import services.OperationService;

@Data
@Accessors(chain = true)
public class Node {
    private Node left;
    private Node right;
    private Operation operation;
    private String value;

    public Node() { }

    public Node(@JsonProperty("operation") String textOperation) {
        this.operation = OperationService.identifyOperation(textOperation);
    }

    public Node(Operation operation) {
        this.operation = operation;
    }

    public boolean hasVariable(String variable){
        boolean res = false;
        res |= hasVariable(this.getLeft(), variable, res);
        res |= hasVariable(this.getRight(), variable, res);

        return res;
    }

    public Node concatNodes(Node leftNode, Node rightNode) {
        return  new Node()
                .setLeft(leftNode)
                .setRight(rightNode)
                .setOperation(
                        leftNode != null
                        && leftNode.getOperation() != null ?
                                leftNode
                                        .getOperation()
                                        .getOppositeOperation() : null);
    }

    private boolean hasVariable(Node child, String variable, boolean res) {
        if(!res){
            if(child != null
                    && child.getValue() != null
                    && child.getValue().equals(variable)){
                res |= true;
            } else {
                if(child != null){
                    res |= hasVariable(child.getLeft(), variable, res);
                    res |= hasVariable(child.getRight(), variable, res);
                }
            }
        }

        return res;
    }
}


package model;

import com.fasterxml.jackson.annotation.JsonGetter;
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

    public boolean hasValriable(Node child, String variable){
        boolean res = false;
        if(!res){
            if(child != null && child.getValue().equals(variable)){
                res |= true;
            } else {
                if(child != null){
                    res |= hasValriable(child.getLeft(), variable, res);
                    res |= hasValriable(child.getRight(), variable, res);
                } else {
                    res |= false;
                }
            }
        }

        return res;
    }

    public boolean hasValriable(Node child, String variable, boolean res) {
        if(!res){
            if(child != null && child.getValue().equals(variable)){
                res |= true;
            } else {
                if(child != null){
                    res |= hasValriable(child.getLeft(), variable, res);
                    res |= hasValriable(child.getRight(), variable, res);
                } else {
                    res |= false;
                }
            }
        }

        return res;
    }
}

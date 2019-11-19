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
}

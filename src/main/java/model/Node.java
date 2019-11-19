package model;

import lombok.Data;
import lombok.experimental.Accessors;
import model.operations.Operation;

@Data
@Accessors(chain = true)
public class Node {
    private Node left;
    private Node right;
    private Operation operation;
    private String value;

    public Node() {}

    public Node(Operation operation) {
        this.operation = operation;
    }

}

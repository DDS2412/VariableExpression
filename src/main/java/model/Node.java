package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Node {
    private Node left;
    private Node right;
    private String operation;
    private String value;
}

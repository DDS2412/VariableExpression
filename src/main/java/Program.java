import model.Node;
import services.ExpressionService;
import services.FileWorkerService;

import java.io.IOException;

public class Program {
    public static void main(final String[] args) throws IOException {
        FileWorkerService fileService = new FileWorkerService();
        Node node = fileService.getNode(args[0]);
        ExpressionService expressionService = new ExpressionService();
        Node expressionNode = expressionService.express(node,"a");
        fileService.saveNode(expressionNode, "test.txt");
        System.out.println(expressionNode.toString());
    }
}

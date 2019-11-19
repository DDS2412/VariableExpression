import model.Node;
import services.FileWorkerService;

import java.io.IOException;

public class Program {
    public static void main(final String[] args) throws IOException {
        FileWorkerService fileService = new FileWorkerService();
        Node node = fileService.getNode(args[0]);
        System.out.println(node);
    }
}

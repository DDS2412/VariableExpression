import com.fasterxml.jackson.databind.ObjectMapper;
import model.Node;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(final String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Node node = mapper.readValue(new File(args[0]), Node.class);
        System.out.println(node);
    }
}

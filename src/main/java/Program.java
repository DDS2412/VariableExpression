import com.fasterxml.jackson.databind.ObjectMapper;
import model.Node;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Program {
    public static void main(final String[] args) throws IOException {
        Program program = new Program();
        File jsonFile = program.getFileFromResources(args[0]);
        Node node =program.getNodeFromJson(jsonFile);
        System.out.println(node);
    }

    private Node getNodeFromJson(File file){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, Node.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Node();
    }

    private File getFileFromResources(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}

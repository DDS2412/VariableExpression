package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Node;

import java.io.File;
import java.net.URL;

public class FileWorkerService {
    public Node getNode(String fileName){
        File jsonFile = getFileFromResources(fileName);
        return getNodeFromJson(jsonFile);
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

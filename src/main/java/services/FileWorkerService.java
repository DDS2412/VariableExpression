package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Node;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorkerService {
    public Node getNode(String fileName){
        File jsonFile = getFileFromResources(fileName);
        return getNodeFromJson(jsonFile);
    }

    public boolean saveNode(Node node, String fileName) {
        File file = getFileFromResources(fileName);
        try {
            if(file.createNewFile()){
                String nodeToString = String.format("`%s`", node.toString());
                Files.write(Paths.get(file.getPath()), nodeToString.getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
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
            System.out.println("Файл отсутсвует!\nБудет создан новый файл!");
            return new File(Paths.get("src", "main","resources").toString() + "/" + fileName);
        } else {
            return new File(resource.getFile());
        }
    }
}

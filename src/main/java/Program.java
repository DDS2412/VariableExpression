import dto.ExpressionDto;
import exception.ConvertException;
import model.Node;
import services.ExpressionConverterService;
import services.FileWorkerService;

import java.io.IOException;

public class Program {
    public static void main(final String[] args) throws ConvertException {
        FileWorkerService fileService = new FileWorkerService();

        ExpressionDto expressionDto = fileService.getExpressionDto(args[0]);
        ExpressionConverterService converterService = new ExpressionConverterService();

        if(converterService.tryToConvertExpressionToNode(expressionDto)){
            Node root =  converterService.convertExpressionToNode(expressionDto);
            System.out.println(root);
        } else {

        }
        //Node node = fileService.getNode(args[0]);

        //fileService.saveNode(node.transferRightNode(), "test.txt");
    }
}

import dto.ExpressionDto;
import dto.InputDto;
import exception.ConvertException;
import model.Node;
import services.ExpressionConverterService;
import services.FileWorkerService;

import java.io.IOException;

public class Program {
    public static void main(final String[] args) throws ConvertException {
        FileWorkerService fileService = new FileWorkerService();

        InputDto inputDto = fileService.getInputDto(args[0]);
        ExpressionConverterService converterService = new ExpressionConverterService();

        if(converterService.tryToConvertExpressionToNode(inputDto.getExpression())){
            Node root =  converterService.convertExpressionToNode(inputDto.getExpression());
            fileService.saveNode(root, "sym.txt");
        } else {

        }
        //Node node = fileService.getNode(args[0]);

        //fileService.saveNode(node.transferRightNode(), "test.txt");
    }
}

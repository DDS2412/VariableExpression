import dto.InputDto;
import exception.ConvertException;
import model.Node;
import services.ExpressionConverterService;
import services.ExpressionService;
import services.FileWorkerService;

public class Program {
    public static void main(final String[] args) throws ConvertException {
        FileWorkerService fileService = new FileWorkerService();

        InputDto inputDto = fileService.getInputDto(args[0]);
        ExpressionConverterService converterService = new ExpressionConverterService();

        if(converterService.tryToConvertExpressionToNode(inputDto.getExpression())){
            Node root =  converterService.convertExpressionToNode(inputDto.getExpression());
            ExpressionService service = new ExpressionService();
            Node expressedNode = service.express(root, inputDto.getVariable());
            System.out.println(expressedNode);
            fileService.saveExpression(expressedNode.toString(), args[1]);
        } else {
            System.out.println(inputDto.getExpression());
            fileService.saveExpression(inputDto.getExpression().toString(), args[2]);
        }
    }
}

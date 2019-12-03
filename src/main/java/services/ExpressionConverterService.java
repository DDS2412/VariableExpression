package services;

import dto.ArgumentDto;
import dto.ExpressionDto;
import dto.HeadDto;
import exception.ConvertException;
import model.Node;
import model.operations.*;

import java.beans.Expression;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ExpressionConverterService {
    public boolean tryToConvertExpressionToNode(ExpressionDto expressionDto){
        boolean isConvert = true;
        try {
            convertExpressionToNode(expressionDto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            isConvert = false;
        }

        return isConvert;
    }

    public Node convertExpressionToNode(ExpressionDto expressionDto) throws ConvertException {
        return convertExpressionToNode(new Node(), expressionDto);
    }

    public ExpressionDto convertNodeToExpression(Node node) {
        ExpressionDto expressionDto = new ExpressionDto();

        List<ArgumentDto> argumentDtos = new ArrayList<>();
        argumentDtos.add(convertNodeToArgumentDto(node.getLeft()));
        argumentDtos.add(convertNodeToArgumentDto(node.getRight()));

        return expressionDto
                .setHead(new HeadDto().setSymbol(node.getOperation() != null ? node.getOperation().toString() : null))
                .setArguments(argumentDtos);
    }

    private ArgumentDto convertNodeToArgumentDto(Node node){
        if(node != null && node.getValue() != null){

            if(tryParseDouble(node.getValue())){
                return  new ArgumentDto().setConstant(node.getValue());
            } else{
                return new ArgumentDto().setSymbol(node.getValue());
            }
        } else {
            return new ArgumentDto().setExpression(convertNodeToExpression(node));
        }
    }

    private Node convertExpressionToNode(Node node, ExpressionDto expressionDto) throws ConvertException {
        node.setOperation(convertOperationFromHead(expressionDto.getHead()));

        switch (getNumberArguments(expressionDto.getArguments())) {
            case 0: {
                node
                        .setLeft(null)
                        .setRight(null);
                break;
            }
            case 1: {
                node
                        .setRight(null)
                        .setLeft(convertArgumentsToNode(new Node(), expressionDto.getArguments().get(0)));

                break;
            }
            case 2: {
                node = node.setLeft(convertArgumentsToNode(new Node(), expressionDto.getArguments().get(0)));
                node.setRight(convertArgumentsToNode(new Node(), expressionDto.getArguments().get(1)));

                break;
            }
        }

        return node;
    }

    private Node convertArgumentsToNode(Node node, ArgumentDto argumentDto) throws ConvertException {
        if(argumentDto.getConstant() != null){
            node
                    .setValue(argumentDto.getConstant())
                    .setRight(null);
        } else if(argumentDto.getSymbol() != null) {
            node
                    .setValue(argumentDto.getSymbol())
                    .setRight(null);
        } else {
            Node currentRoot = convertExpressionToNode(new Node(), argumentDto.getExpression());
            node
                    .setLeft(currentRoot.getLeft())
                    .setRight(currentRoot.getRight())
                    .setOperation(currentRoot.getOperation());
        }

        return node;
    }

    private int getNumberArguments(List<ArgumentDto> argumentDtos) throws ConvertException {
        if(argumentDtos.size() > 0 && argumentDtos.size() < 3) {
            for (ArgumentDto argumentDto : argumentDtos) {
                checkArgumentValidation(argumentDto);
            }
        } else{
            throw new ConvertException(String.format("Количество аргументов %d невозможно преобразовать в бинарное дерево", argumentDtos.size()));
        }

        return argumentDtos.size();
    }

    private void checkArgumentValidation(ArgumentDto argumentDto) throws ConvertException {
        if(!(argumentDto.getSymbol() == null && argumentDto.getConstant() == null && argumentDto.getExpression() != null ||
                argumentDto.getSymbol() == null && argumentDto.getConstant() != null && argumentDto.getExpression() == null ||
                argumentDto.getSymbol() != null && argumentDto.getConstant() == null && argumentDto.getExpression() == null)) {
            throw new ConvertException(String.format("Неверный формат аргумента %s", argumentDto));
        }
    }

    private Operation convertOperationFromHead(HeadDto headDto) throws ConvertException {
        switch (headDto.getSymbol()){
            case "+" : return new Addition();
            case "-" : return new Subtraction();
            case "*" : return new Multiplication();
            case "=" : return new Equality();
            case "/" : return new Division();
            case "^" : return new Pow();
            case "^1/" : return new SquarePow();
            default: throw new ConvertException("Недопустимый символ");
        }
    }

    private boolean tryParseDouble(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}


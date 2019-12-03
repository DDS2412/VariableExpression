package services;

import model.operations.*;

public class OperationService {

    public static Operation identifyOperation(String textOperation) {
        if (textOperation != null) {
            switch (textOperation) {
                case "+": {
                    return new Addition();
                }
                case "-": {
                    return new Subtraction();
                }
                case "*": {
                    return new Multiplication();
                }
                case "/": {
                    return new Division();
                }
                case "=": {
                    return new Equality();
                }
                case "^": {
                    return new Pow();
                }
                case "^1/": {
                    return new SquarePow();
                }
            }
        }

        return null;
    }
}

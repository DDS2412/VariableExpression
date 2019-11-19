package services;

import model.operations.Addition;
import model.operations.Equality;
import model.operations.Operation;
import model.operations.Subtraction;

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
                case "=": {
                    return new Equality();
                }
            }
        }

        return null;
    }
}

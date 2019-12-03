package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class InputDto {
    private ExpressionDto expression;

    private String variable;
}

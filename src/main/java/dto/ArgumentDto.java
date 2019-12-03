package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ArgumentDto {

    private ExpressionDto expression;

    private String constant;

    private String symbol;
}

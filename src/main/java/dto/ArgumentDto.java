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

    @Override
    public String toString(){
        return String.format("%s%s%s", expression == null ? "" : expression, getFormattedString(constant), getFormattedString(symbol));
    }

    private String getFormattedString(String str){
        return str == null ? "" : str;
    }
}

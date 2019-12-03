package dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonTypeName("expression")
public class ExpressionDto {

    private HeadDto head;

    private List<ArgumentDto> arguments;

    @Override
    public String toString(){
        String result = "";
        if(arguments.size() > 2){
            result += head.getSymbol().equals("=") ? "" : "(";
            result += String.format("%s %s (%s", arguments.get(0), head.getSymbol(), arguments.get(1));

            for(int i = 2; i < arguments.size(); i++){
                result = String.format("%s, %s", result, arguments.get(i));
            }

            result += head.getSymbol().equals("=") ? ")" : "))";

        } else if(arguments.size() < 1){
            result += "";
        } else{
            result += head.getSymbol().equals("=") ? "" : "(";
            result += String.format("%s %s %s", arguments.get(0), head.getSymbol(), arguments.size() == 2 ? arguments.get(1) : "");
            result += head.getSymbol().equals("=") ? "" : ")";
        }

        return result;
    }
}

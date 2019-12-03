package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
}

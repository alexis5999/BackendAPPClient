package intercorp.com.pe.springboot.app.clientes.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ApiModel(description = "Desviacion standar entre las edades del cliente ")
public class KpiClientsResponse {

    @JsonProperty("average_age")
    @ApiModelProperty(notes = "edades del cliente")
    private int averageAge;

    @JsonProperty("standard_deviation")
    @ApiModelProperty(notes = "desviacion standar")
    private double standardDeviation;
}

package intercorp.com.pe.springboot.app.clientes.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import intercorp.com.pe.springboot.app.clientes.models.entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@ApiModel(description = "Cliente Fecha estimada de Muerte")
public class ClientDataResponse {

    @JsonProperty("client")
    @ApiModelProperty(notes = "Datos de cliente")
    private Employee employee;

    @JsonProperty("death_date")
    @ApiModelProperty(notes = "Fecha estimada de Muerte")
    private Date deathDate;
}

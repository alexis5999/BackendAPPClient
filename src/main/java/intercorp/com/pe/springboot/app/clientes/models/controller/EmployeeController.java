package intercorp.com.pe.springboot.app.clientes.models.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;


import intercorp.com.pe.springboot.app.clientes.models.entity.Employee;
import intercorp.com.pe.springboot.app.clientes.models.exception.ResourceNotFoundException;
import intercorp.com.pe.springboot.app.clientes.models.repository.EmployeeRepository;
import intercorp.com.pe.springboot.app.clientes.models.response.ClientDataResponse;
import intercorp.com.pe.springboot.app.clientes.models.response.KpiClientsResponse;
import intercorp.com.pe.springboot.app.clientes.models.services.EmployeeServices;
import io.swagger.annotations.ApiOperation;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
				 
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}


    @GetMapping("/kpideclientes")
    @ApiOperation(value = "Retornar los clientes para obtener la desviacion standar entre las edades de los clientes",
            response = KpiClientsResponse.class)
    public KpiClientsResponse getClientsKpi() throws JsonProcessingException, ParseException {
        return employeeServices.getKpiClients();
    }

    @GetMapping("/listarclientes")
    @ApiOperation(value = "Listar clientes x fecha probable de muerte", response = ClientDataResponse.class,
            responseContainer = "List")
    public List<ClientDataResponse> listClients() throws JsonProcessingException, ParseException {
        return employeeServices.getClientsData();
    }


	
}

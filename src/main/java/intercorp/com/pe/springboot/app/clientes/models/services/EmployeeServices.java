package intercorp.com.pe.springboot.app.clientes.models.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import intercorp.com.pe.springboot.app.clientes.models.client.RestClient;
import intercorp.com.pe.springboot.app.clientes.models.entity.Employee;
import intercorp.com.pe.springboot.app.clientes.models.repository.EmployeeRepository;
import intercorp.com.pe.springboot.app.clientes.models.response.ClientDataResponse;
import intercorp.com.pe.springboot.app.clientes.models.response.KpiClientsResponse;
import intercorp.com.pe.springboot.app.clientes.models.utils.MathUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import static java.util.Objects.isNull;

@Service
public class EmployeeServices {



    @Autowired
    RestClient restClient;
    
	@Autowired
	private EmployeeRepository employeeRepository;
   
  	Employee employee;

     
    public KpiClientsResponse getKpiClients() throws JsonProcessingException, ParseException {
    	
  
        
    	List<Employee> clients = employeeRepository.findAll();

        List<Integer> ages = getAges(clients);

        int averageAge = MathUtils.calculateAgeAverage(ages);

        double standardDeviation = MathUtils.calculateStandardDeviation(ages);
        

        return KpiClientsResponse.builder()
                .averageAge(averageAge)
                .standardDeviation(standardDeviation)
                .build();
    }


    public List<ClientDataResponse> getClientsData() throws JsonProcessingException, ParseException {
 
        
    	List<Employee> clients = employeeRepository.findAll();
        
        
        int ageAverage = MathUtils.calculateAgeAverage(getAges(clients));

        List<ClientDataResponse> response = new ArrayList<>();
        for (Employee client : clients) {
            response.add(ClientDataResponse.builder()
                    .employee(client)
                    .deathDate(getEstimatedDeathDate(client.getBirthdate(), ageAverage))
                    .build());
        }

        return response;
    }


    private Date getEstimatedDeathDate(Date birthDate, int averageAge) {
        return MathUtils.estimatedDeathDate(birthDate, averageAge);
    }


    private List<Integer> getAges(List<Employee> clients) {
        return clients.stream()
                .map(Employee::getAge)
                .collect(Collectors.toList());
    }

   
    private void validateClient(Employee client) {
        if (isNull(client) ||
                isNull(client.getFirstName()) ||
                isNull(client.getLastName()) ||
                isNull(client.getAge()) ||
                isNull(client.getBirthdate())) {
            throw new IllegalArgumentException("The client or your attributes does not be null");
        }
    }
}

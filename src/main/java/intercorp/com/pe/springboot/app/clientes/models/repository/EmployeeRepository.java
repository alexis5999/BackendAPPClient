package intercorp.com.pe.springboot.app.clientes.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intercorp.com.pe.springboot.app.clientes.models.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

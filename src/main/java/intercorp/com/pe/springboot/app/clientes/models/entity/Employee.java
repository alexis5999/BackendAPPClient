package intercorp.com.pe.springboot.app.clientes.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private Date birthdate;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, int age, Date birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthdate = birthdate;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", birthdate=" + birthdate +
				'}';
	}

	public static class Builder {
		private long id;
		private String firstName;
		private String lastName;
		private int age;
		private Date birthdate;
		
		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withAge(Integer age) {
			this.age = age;
			return this;
		}

		public Builder withBirthdate(Date birthdate) {
			this.birthdate = birthdate;
			return this;
		}

		public Employee build() {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setAge(age);
			employee.setBirthdate(birthdate);

			return employee;
		}
	}
	
}

package model;

public class DepJoining {

	Integer id;
	Department department;
	Employee employee;
	String role;

	public DepJoining(Department department, Employee employee, String role) {
		super();
		this.department = department;
		this.employee = employee;
		this.role = role;
	}

	public DepJoining(Integer id, Department department, Employee employee, String role) {
		super();
		this.id = id;
		this.department = department;
		this.employee = employee;
		this.role = role;
	}

	public DepJoining() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connect.DBConnect;
import model.DepJoining;
import model.Department;
import model.Employee;
import model.Job;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table employee in the database
 */
public class EmployeeDAO {

	Connection connection = DBConnect.getConnection();
	private JobDAO jobDAO;
	private DepartmentDAO departmentDAO;

	public EmployeeDAO() {
		jobDAO = new JobDAO();
		departmentDAO = new DepartmentDAO();
	}

	public List<Employee> selectAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		try {
			String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String emId = rs.getString("emId");
				String emName = rs.getString("emName");
				Boolean emGender = rs.getBoolean("emGender");
				String emAddress = rs.getString("emAddress");
				String emPhone = rs.getString("emPhone");
				String emEmail = rs.getString("emEmail");
				Date emHiredDate = rs.getDate("emHiredDate");
				Integer jobId = rs.getInt("jobId");
				Job job = jobDAO.selectJob(jobId);
				Double emSalary = rs.getDouble("emSalary");

				employees.add(new Employee(id, emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, job,
						emSalary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	// TO-DO: Implement selectEmployee() method to select employee by ID (use in
	// UPDATE function)
	public Employee selectEmployee(Integer id) {

		Employee employee = null;
		try {
			String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String emId = rs.getString("emId");
				String emName = rs.getString("emName");
				Boolean emGender = rs.getBoolean("emGender");
				String emAddress = rs.getString("emAddress");
				String emPhone = rs.getString("emPhone");
				String emEmail = rs.getString("emEmail");
				Date emHiredDate = rs.getDate("emHiredDate");

				Integer jobId = rs.getInt("jobId");
				Job job = jobDAO.selectJob(jobId);
				Double emSalary = rs.getDouble("emSalary");
				employee = new Employee(id, emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, job,
						emSalary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	// TO-DO: Implement insertEmployee() method to add new record to table Employee
	public void insertEmployee(Employee employee) throws SQLException {

		try {
			// when user dont input for jobId and emHiredDate
			if (employee.getJob() == null && employee.getEmHiredDate() == null) {
				String INSERT_EMPLOYEE = "INSERT INTO employee (emId, emName, emGender, emAddress, emPhone, emEmail, emSalary) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
				ps.setString(1, employee.getEmId());
				ps.setString(2, employee.getEmName());
				ps.setBoolean(3, employee.getEmGender());
				ps.setString(4, employee.getEmAddress());
				ps.setString(5, employee.getEmPhone());
				ps.setString(6, employee.getEmEmail());
				ps.setDouble(7, employee.getEmSalary());

				ps.executeUpdate();
			}
			// when user dont input for emHiredDate
			else if (employee.getEmHiredDate() == null) {

				String INSERT_EMPLOYEE = "INSERT INTO employee (emId, emName, emGender, emAddress, emPhone, emEmail, jobId, emSalary) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
				ps.setString(1, employee.getEmId());
				ps.setString(2, employee.getEmName());
				ps.setBoolean(3, employee.getEmGender());
				ps.setString(4, employee.getEmAddress());
				ps.setString(5, employee.getEmPhone());
				ps.setString(6, employee.getEmEmail());
				ps.setInt(7, employee.getJob().getId());
				ps.setDouble(8, employee.getEmSalary());

				ps.executeUpdate();
			}
			// when user dont input for jobId
			else if (employee.getJob() == null) {
				String INSERT_EMPLOYEE = "INSERT INTO employee (emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, emSalary) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
				ps.setString(1, employee.getEmId());
				ps.setString(2, employee.getEmName());
				ps.setBoolean(3, employee.getEmGender());
				ps.setString(4, employee.getEmAddress());
				ps.setString(5, employee.getEmPhone());
				ps.setString(6, employee.getEmEmail());
				ps.setDate(7, new java.sql.Date(employee.getEmHiredDate().getTime()));
				ps.setDouble(8, employee.getEmSalary());

				ps.executeUpdate();
			}
			// when user input for all attributes
			else {
				String INSERT_EMPLOYEE = "INSERT INTO employee (emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, jobId, emSalary) VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
				ps.setString(1, employee.getEmId());
				ps.setString(2, employee.getEmName());
				ps.setBoolean(3, employee.getEmGender());
				ps.setString(4, employee.getEmAddress());
				ps.setString(5, employee.getEmPhone());
				ps.setString(6, employee.getEmEmail());
				ps.setDate(7, new java.sql.Date(employee.getEmHiredDate().getTime()));
				ps.setInt(8, employee.getJob().getId());
				ps.setDouble(9, employee.getEmSalary());

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TO-DO: Implement updateEmployee() method to update record in table Employee
	public boolean updateEmployee(Employee employee) throws SQLException {

		boolean rowUpdated = false;
		try {
			String UPDATE_EMPLOYEE = "UPDATE employee SET emId = ?, emName = ?, emGender = ?, "
					+ "emAddress = ?, emPhone = ?, emEmail = ?, emHiredDate = ?, "
					+ "jobId = ?, emSalary = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE);
			ps.setString(1, employee.getEmId());
			ps.setString(2, employee.getEmName());
			ps.setBoolean(3, employee.getEmGender());
			ps.setString(4, employee.getEmAddress());
			ps.setString(5, employee.getEmPhone());
			ps.setString(6, employee.getEmEmail());
			ps.setDate(7, new java.sql.Date(employee.getEmHiredDate().getTime()));
			ps.setInt(8, employee.getJob().getId());
			ps.setDouble(9, employee.getEmSalary());
			ps.setInt(10, employee.getId());
			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteEmployee() method to delete record in table Employee
	public boolean deleteEmployee(Integer id) throws SQLException {

		boolean rowDeleted = false;
		try {
			String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public List<Employee> selectAllEmployeesHaveSameJob(Integer job_id) {
		List<Employee> employees = new ArrayList<>();

		try {
			String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee WHERE jobId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			preparedStatement.setInt(1, job_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String emId = rs.getString("emId");
				String emName = rs.getString("emName");
				Boolean emGender = rs.getBoolean("emGender");
				String emAddress = rs.getString("emAddress");
				String emPhone = rs.getString("emPhone");
				String emEmail = rs.getString("emEmail");
				Date emHiredDate = rs.getDate("emHiredDate");
				Integer jobId = rs.getInt("jobId");
				Job job = jobDAO.selectJob(jobId);
				Double emSalary = rs.getDouble("emSalary");

				employees.add(new Employee(id, emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, job,
						emSalary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<DepJoining> selectAllEmployeesInSameDepartment(Integer department_id) {
		List<DepJoining> depJoinings = new ArrayList<>();

		try {
			String SELECT_ALL_EMPLOYEES = "SELECT * FROM depJoining WHERE departmentId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			preparedStatement.setInt(1, department_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer departmentId = rs.getInt("departmentId");
				Department department = departmentDAO.selectDepartment(departmentId);
				Integer employeeId = rs.getInt("employeeId");
				Employee employee = selectEmployee(employeeId);
				String role = rs.getString("role");
				depJoinings.add(new DepJoining(id, department, employee, role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depJoinings;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.Department;
import model.Employee;
import model.Job;

public class DepartmentDAO {

	Connection connection = DBConnect.getConnection();
	private JobDAO jobDAO;

	public DepartmentDAO() {
		jobDAO = new JobDAO();
	}

	public List<Department> selectAllDepartments() {
		List<Department> departments = new ArrayList<>();

		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_DEPARTMENTS = "SELECT * FROM department";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENTS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String depId = rs.getString("depId");
				String depName = rs.getString("depName");
				departments.add(new Department(id, depId, depName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	// TO-DO: Implement selectDepartment() method to select department by ID (use in
	// UPDATE function)
	public Department selectDepartment(Integer id) {
		Department department = null;
		try {
			String SELECT_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String depName = rs.getString("depName");
				String depId = rs.getString("depId");
				department = new Department(id, depId, depName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	// TO-DO: Implement insertDepartment() method to add new record to table
	// Department
	public void insertDepartment(Department department) throws SQLException {
		try {
			String INSERT_DEPARTMENT = "INSERT INTO department (depId, depName) VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_DEPARTMENT);
			ps.setString(1, department.getDepId());
			ps.setString(2, department.getDepName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TO-DO: Implement updateDepartment() method to update record in table
	// Department
	public boolean updateDepartment(Department department) throws SQLException {
		boolean rowUpdated = false;
		try {
			// (emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate,
			// emDepartment, departmentId, emSalary)
			String UPDATE_DEPARTMENT = "UPDATE department SET depId = ?, depName = ?" + " WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_DEPARTMENT);
			ps.setString(1, department.getDepId());
			ps.setString(2, department.getDepName());
			ps.setInt(3, department.getId());

			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteDepartment() method to delete record in table
	// Department
	public boolean deleteDepartment(Integer id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_DEPARTMENT = "DELETE FROM department WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_DEPARTMENT);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

}

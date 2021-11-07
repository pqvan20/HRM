package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.DepJoining;
import model.Department;
import model.Employee;

public class DepJoiningDAO {

	Connection connection = DBConnect.getConnection();
	private DepartmentDAO departmentDAO;
	private EmployeeDAO employeeDAO;

	public DepJoiningDAO() {
		departmentDAO = new DepartmentDAO();
		employeeDAO = new EmployeeDAO();
	}

	public List<DepJoining> selectAllDepJoinings() {
		List<DepJoining> depJoinings = new ArrayList<>();

		try {
			String SELECT_ALL_DEPARTMENTS = "SELECT * FROM depJoining";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENTS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer departmentId = rs.getInt("departmentId");
				Department department = departmentDAO.selectDepartment(departmentId);
				Integer employeeId = rs.getInt("employeeId");
				Employee employee = employeeDAO.selectEmployee(employeeId);
				String role = rs.getString("role");
				depJoinings.add(new DepJoining(id, department, employee, role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depJoinings;
	}

	// TO-DO: Implement selectDepJoining() method to select depJoining by ID (use in
	// UPDATE function)
	public DepJoining selectDepJoining(Integer id) {
		DepJoining depJoining = null;
		try {
			String SELECT_DEPARTMENT_BY_ID = "SELECT * FROM depJoining WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer departmentId = rs.getInt("departmentId");
				Department department = departmentDAO.selectDepartment(departmentId);
				Integer employeeId = rs.getInt("employeeId");
				Employee employee = employeeDAO.selectEmployee(employeeId);
				String role = rs.getString("role");
				depJoining = new DepJoining(id, department, employee, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depJoining;
	}

	// TO-DO: Implement insertDepJoining() method to add new record to table
	// DepJoining
	public void insertDepJoining(DepJoining depJoining) throws SQLException {
		try {
			String INSERT_DEPARTMENT = "INSERT INTO depJoining (departmentId, employeeId, role) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_DEPARTMENT);
			ps.setInt(1, depJoining.getDepartment().getId());
			ps.setInt(2, depJoining.getEmployee().getId());
			ps.setString(3, depJoining.getRole());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TO-DO: Implement updateDepJoining() method to update record in table
	// DepJoining
	public boolean updateDepJoining(DepJoining depJoining) throws SQLException {
		boolean rowUpdated = false;
		try {
			// (emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate,
			// emDepJoining, depJoiningId, emSalary)
			String UPDATE_DEPARTMENT = "UPDATE depJoining SET departmentId = ?, employeeId = ?, role = ?" + " WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_DEPARTMENT);
			ps.setInt(1, depJoining.getDepartment().getId());
			ps.setInt(2, depJoining.getEmployee().getId());
			ps.setString(3, depJoining.getRole());
			ps.setInt(4, depJoining.getId());

			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteDepJoining() method to delete record in table
	// DepJoining
	public boolean deleteDepJoining(Integer id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_DEPARTMENT = "DELETE FROM depJoining WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_DEPARTMENT);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

}

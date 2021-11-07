package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connect.DBConnect;
import model.Employee;
import model.Job;

public class JobDAO {

	Connection connection = DBConnect.getConnection();

	public JobDAO() {
	}

	public List<Job> selectAllJobs() {
		List<Job> jobs = new ArrayList<>();

		try {
			String SELECT_ALL_EMPLOYEES = "SELECT * FROM job";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String jobId = rs.getString("jobId");
				String jobName = rs.getString("jobName");
				jobs.add(new Job(id, jobId, jobName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	// TO-DO: Implement selectJob() method to select job by ID (use in
	// UPDATE function)
	public Job selectJob(Integer id) {
		Job job = null;
		try {
			String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM job WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String jobId = rs.getString("jobId");
				String jobName = rs.getString("jobName");
				job = new Job(id, jobId, jobName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return job;
	}

	// TO-DO: Implement insertJob() method to add new record to table Job
	public void insertJob(Job job) throws SQLException {
		try {
			String INSERT_EMPLOYEE = "INSERT INTO job (jobId, jobName) VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE);
			ps.setString(1, job.getJobId());
			ps.setString(2, job.getJobName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TO-DO: Implement updateJob() method to update record in table Job
	public boolean updateJob(Job job) throws SQLException {
		boolean rowUpdated = false;
		try {
			// (emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate,
			// emDepartment, jobId, emSalary)
			String UPDATE_EMPLOYEE = "UPDATE job SET jobId = ?, jobName = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE);
			ps.setString(1, job.getJobId());
			ps.setString(2, job.getJobName());
			ps.setInt(3, job.getId());
			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// TO-DO: Implement deleteJob() method to delete record in table Job
	public boolean deleteJob(Integer id) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_EMPLOYEE = "DELETE FROM job WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

}

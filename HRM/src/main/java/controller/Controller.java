package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepJoiningDAO;
import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import model.DepJoining;
import model.Department;
import model.Employee;
import model.Job;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the employee.
 */

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	private JobDAO jobDAO;
	private DepartmentDAO departmentDAO;
	private DepJoiningDAO depJoiningDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
		jobDAO = new JobDAO();
		departmentDAO = new DepartmentDAO();
		depJoiningDAO = new DepJoiningDAO();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String action = request.getServletPath();

		try {
			switch (action) {

			// EMPLOYEE
			case "/newEmployee":
				showNewEmployeeForm(request, response);
				break;
			case "/insertEmployee":
				insertEmployee(request, response);
				break;
			case "/deleteEmployee":
				deleteEmployee(request, response);
				break;
			case "/editEmployee":
				showEmployeeEditForm(request, response);
				break;
			case "/updateEmployee":
				updateEmployee(request, response);
				break;
			case "/listEmployee":
				listEmployee(request, response);
				break;
			case "/seeEmployeeDetails":
				seeEmployeeDetails(request, response);
				break;

			// JOB
			case "/newJob":
				showNewJobForm(request, response);
				break;
			case "/insertJob":
				insertJob(request, response);
				break;
			case "/insertJobOfPopUp":
				insertJobOfPopUp(request, response);
				break;
			case "/deleteJob":
				deleteJob(request, response);
				break;
			case "/editJob":
				showJobEditForm(request, response);
				break;
			case "/updateJob":
				updateJob(request, response);
				break;
			case "/listJob":
				listJob(request, response);
				break;
			case "/seeJobDetails":
				seeJobDetails(request, response);
				break;
			// DEPARTMENT
			case "/newDepartment":
				showNewDepartmentForm(request, response);
				break;
			case "/insertDepartment":
				insertDepartment(request, response);
				break;
			case "/insertDepartmentOfPopUp":
				insertDepartmentOfPopUp(request, response);
				break;
			case "/deleteDepartment":
				deleteDepartment(request, response);
				break;
			case "/editDepartment":
				showDepartmentEditForm(request, response);
				break;
			case "/updateDepartment":
				updateDepartment(request, response);
				break;
			case "/listDepartment":
				listDepartment(request, response);
				break;
			case "/seeDepartmentDetails":
				seeDepartmentDetails(request, response);
				break;

			// DEP-JOINING
			case "/newDepJoining":
				showNewDepJoiningForm(request, response);
				break;
			case "/insertDepJoining":
				insertDepJoining(request, response);
				break;
			case "/insertDepJoiningOfPopUp":
				insertDepJoiningOfPopUp(request, response);
				break;
			case "/deleteDepJoining":
				deleteDepJoining(request, response);
				break;
			case "/editDepJoining":
				showDepJoiningEditForm(request, response);
				break;
			case "/updateDepJoining":
				updateDepJoining(request, response);
				break;
			case "/listDepJoining":
				listDepJoining(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// EMPLOYEE
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/employee-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Job> listJob = jobDAO.selectAllJobs();
		request.setAttribute("listJob", listJob);
		List<Department> listDepartment = departmentDAO.selectAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/add-employee.jsp");
		dispatcher.forward(request, response);
	}

	private void showEmployeeEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDAO.selectEmployee(id);
		List<Job> listJob = jobDAO.selectAllJobs();
		request.setAttribute("listJob", listJob);
		List<Department> listDepartment = departmentDAO.selectAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit-employee.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emId = request.getParameter("emId");
		String emName = request.getParameter("emName");
		Boolean emGender = Boolean.parseBoolean(request.getParameter("emGender"));
		String emAddress = request.getParameter("emAddress");
		String emPhone = request.getParameter("emPhone");
		String emEmail = request.getParameter("emEmail");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date emHiredDate = null;
		try {
			emHiredDate = formatter.parse(request.getParameter("emHiredDate"));
		} catch (Exception e) {
			System.err.println("No inputing for date");
		}
		Integer jobId = null;
		Job job = null;
		try {
			jobId = Integer.parseInt(request.getParameter("jobId"));
			job = jobDAO.selectJob(jobId);
		} catch (Exception e) {
			System.err.println("No inputing for jobId");
		}
		Double emSalary = Double.parseDouble(request.getParameter("emSalary"));
		Employee newEmployee = new Employee(emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, job,
				emSalary);
		employeeDAO.insertEmployee(newEmployee);
		response.sendRedirect("list");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String emId = request.getParameter("emId");
		String emName = request.getParameter("emName");
		Boolean emGender = Boolean.parseBoolean(request.getParameter("emGender"));
		String emAddress = request.getParameter("emAddress");
		String emPhone = request.getParameter("emPhone");
		String emEmail = request.getParameter("emEmail");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date emHiredDate = null;
		try {
			emHiredDate = formatter.parse(request.getParameter("emHiredDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("date error");
			e.printStackTrace();
		}
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		Job job = jobDAO.selectJob(jobId);
		Double emSalary = Double.parseDouble(request.getParameter("emSalary"));

		Employee employee = new Employee(id, emId, emName, emGender, emAddress, emPhone, emEmail, emHiredDate, job,
				emSalary);
		employeeDAO.updateEmployee(employee);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.deleteEmployee(id);
		response.sendRedirect("list");
	}

	private void seeEmployeeDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.selectEmployee(id);
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/employee-details.jsp");
		dispatcher.forward(request, response);
	}

	// JOB
	private void listJob(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Job> listJob = jobDAO.selectAllJobs();
		request.setAttribute("listJob", listJob);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/job/job-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewJobForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/job/add-job.jsp");
		dispatcher.forward(request, response);
	}

	private void insertJob(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		Job newJob = new Job(jobId, jobName);
		jobDAO.insertJob(newJob);
		response.sendRedirect("listJob");
	}

	private void insertJobOfPopUp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String jobId = request.getParameter("jobId");

		String jobName = request.getParameter("jobName");
		Job newJob = new Job(jobId, jobName);
		jobDAO.insertJob(newJob);
		try {
			showNewEmployeeForm(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showJobEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Job existingJob = jobDAO.selectJob(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/job/edit-job.jsp");
		request.setAttribute("job", existingJob);
		dispatcher.forward(request, response);
	}

	private void updateJob(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		Job job = new Job(id, jobId, jobName);
		jobDAO.updateJob(job);
		response.sendRedirect("listJob");
	}

	private void deleteJob(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		jobDAO.deleteJob(id);
		response.sendRedirect("listJob");
	}

	private void seeJobDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Job job = jobDAO.selectJob(id);
		request.setAttribute("job", job);
		List<Employee> listEmployee = employeeDAO.selectAllEmployeesHaveSameJob(id);
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/job/job-details.jsp");
		dispatcher.forward(request, response);
	}

	// DEPARTMENT
	private void listDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Department> listDepartment = departmentDAO.selectAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/department/department-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewDepartmentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/department/add-department.jsp");
		dispatcher.forward(request, response);
	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String depId = request.getParameter("depId");
		String depName = request.getParameter("depName");
		Department newDepartment = new Department(depId, depName);
		departmentDAO.insertDepartment(newDepartment);
		response.sendRedirect("listDepartment");
	}

	private void insertDepartmentOfPopUp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String depId = request.getParameter("depId");
		String depName = request.getParameter("depName");
		Department newDepartment = new Department(depId, depName);
		departmentDAO.insertDepartment(newDepartment);
		try {
			showNewEmployeeForm(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDepartmentEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Department existingDepartment = departmentDAO.selectDepartment(id);
		List<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/department/edit-department.jsp");
		request.setAttribute("department", existingDepartment);
		dispatcher.forward(request, response);
	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String depId = request.getParameter("depId");
		String depName = request.getParameter("depName");
		Department department = new Department(id, depId, depName);
		departmentDAO.updateDepartment(department);
		response.sendRedirect("listDepartment");
	}

	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		departmentDAO.deleteDepartment(id);
		response.sendRedirect("listDepartment");
	}

	private void seeDepartmentDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Department department = departmentDAO.selectDepartment(id);
		request.setAttribute("department", department);
		List<DepJoining> listDepJoining = employeeDAO.selectAllEmployeesInSameDepartment(id);
		request.setAttribute("listDepJoining", listDepJoining);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/department/department-details.jsp");
		dispatcher.forward(request, response);
	}

	// DEPJOINING
	private void listDepJoining(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<DepJoining> listDepJoining = depJoiningDAO.selectAllDepJoinings();
		request.setAttribute("listDepJoining", listDepJoining);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/depJoining/depJoining-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewDepJoiningForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/depJoining/add-depJoining.jsp");
		List<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		List<Department> listDepartment = departmentDAO.selectAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		dispatcher.forward(request, response);
	}

	private void insertDepJoining(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
		Department department = departmentDAO.selectDepartment(departmentId);
		Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
		Employee employee = employeeDAO.selectEmployee(employeeId);
		String role = request.getParameter("role");
		DepJoining newDepJoining = new DepJoining(department, employee, role);
		depJoiningDAO.insertDepJoining(newDepJoining);
		response.sendRedirect("listDepJoining");
	}

	private void insertDepJoiningOfPopUp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
		Department department = departmentDAO.selectDepartment(departmentId);
		Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
		Employee employee = employeeDAO.selectEmployee(employeeId);
		String role = request.getParameter("role");
		DepJoining newDepJoining = new DepJoining(department, employee, role);
		depJoiningDAO.insertDepJoining(newDepJoining);
		try {
			showNewEmployeeForm(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showDepJoiningEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DepJoining existingDepJoining = depJoiningDAO.selectDepJoining(id);
		List<Employee> listEmployee = employeeDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		List<Department> listDepartment = departmentDAO.selectAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/depJoining/edit-depJoining.jsp");
		request.setAttribute("depJoining", existingDepJoining);
		dispatcher.forward(request, response);
	}

	private void updateDepJoining(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
		Department department = departmentDAO.selectDepartment(departmentId);
		Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
		Employee employee = employeeDAO.selectEmployee(employeeId);
		String role = request.getParameter("role");
		DepJoining depJoining = new DepJoining(id, department, employee, role);
		depJoiningDAO.updateDepJoining(depJoining);
		response.sendRedirect("listDepJoining");
	}

	private void deleteDepJoining(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		depJoiningDAO.deleteDepJoining(id);
		response.sendRedirect("listDepJoining");
	}
}

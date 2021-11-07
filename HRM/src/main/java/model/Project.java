package model;

import java.util.Date;
import java.util.List;

public class Project {

	private Integer id;
	private String projectId;
	private String projectName;
	private String projectRequirement;
	private Date startDate;
	private Date finishDate;
	private Date deadline;
	private String priority;
	private String status;
	private List<Task> tasks;

	public Project(Integer id, String projectId, String projectName, String projectRequirement, Date startDate,
			Date finishDate, Date deadline, String priority, String status, List<Task> tasks) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectRequirement = projectRequirement;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.deadline = deadline;
		this.priority = priority;
		this.status = status;
		this.tasks = tasks;
	}

	public Project(Integer id, String projectId, String projectName, String projectRequirement, Date startDate,
			Date finishDate, Date deadline, String priority, String status) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectRequirement = projectRequirement;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.deadline = deadline;
		this.priority = priority;
		this.status = status;
	}

	public Project() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectRequirement() {
		return projectRequirement;
	}

	public void setProjectRequirement(String projectRequirement) {
		this.projectRequirement = projectRequirement;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}

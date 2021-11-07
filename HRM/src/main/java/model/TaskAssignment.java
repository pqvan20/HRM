package model;

public class TaskAssignment {

	private Integer id;
	private Task task;
	private Employee employee;
	private String note;

	public TaskAssignment(Integer id, Task task, Employee employee, String note) {
		super();
		this.id = id;
		this.task = task;
		this.employee = employee;
		this.note = note;
	}

	public TaskAssignment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

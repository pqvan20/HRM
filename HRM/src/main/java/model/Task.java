package model;

import java.util.Date;
import java.util.List;

public class Task {

	private Integer id;
	private String taskName;
	private String taskRequirement;
	private Date startDate;
	private Date finishDate;
	private Date deadline;
	private Priority priority;
	private Boolean status;
	private Project project;
	private List<TaskAssignment> taskAssignments;

	

}

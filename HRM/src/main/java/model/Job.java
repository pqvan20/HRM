package model;

public class Job {

	// Fields of Job
	Integer id;
	String jobId;
	String jobName;

	public Job(Integer id, String jobId, String jobName) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public Job(String jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}

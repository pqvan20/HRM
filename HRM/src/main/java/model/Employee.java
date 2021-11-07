package model;

import java.util.Date;

public class Employee {

	private Integer id;
	private String emId;
	private String emName;
	private Boolean emGender;
	private String emAddress;
	private String emPhone;
	private String emEmail;
	private Date emHiredDate;
	private Job job;
	private Double emSalary;

	public Employee(String emId, String emName, Boolean emGender, String emAddress, String emPhone, String emEmail,
			Date emHiredDate, Job job, Double emSalary) {
		super();
		this.emId = emId;
		this.emName = emName;
		this.emGender = emGender;
		this.emAddress = emAddress;
		this.emPhone = emPhone;
		this.emEmail = emEmail;
		this.emHiredDate = emHiredDate;
		this.job = job;
		this.emSalary = emSalary;
	}

	public Employee(Integer id, String emId, String emName, Boolean emGender, String emAddress, String emPhone,
			String emEmail, Date emHiredDate, Job job, Double emSalary) {
		super();
		this.id = id;
		this.emId = emId;
		this.emName = emName;
		this.emGender = emGender;
		this.emAddress = emAddress;
		this.emPhone = emPhone;
		this.emEmail = emEmail;
		this.emHiredDate = emHiredDate;
		this.job = job;
		this.emSalary = emSalary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmId() {
		return emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public Boolean getEmGender() {
		return emGender;
	}

	public void setEmGender(Boolean emGender) {
		this.emGender = emGender;
	}

	public String getEmAddress() {
		return emAddress;
	}

	public void setEmAddress(String emAddress) {
		this.emAddress = emAddress;
	}

	public String getEmPhone() {
		return emPhone;
	}

	public void setEmPhone(String emPhone) {
		this.emPhone = emPhone;
	}

	public String getEmEmail() {
		return emEmail;
	}

	public void setEmEmail(String emEmail) {
		this.emEmail = emEmail;
	}

	public Date getEmHiredDate() {
		return emHiredDate;
	}

	public void setEmHiredDate(Date emHiredDate) {
		this.emHiredDate = emHiredDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Double getEmSalary() {
		return emSalary;
	}

	public void setEmSalary(Double emSalary) {
		this.emSalary = emSalary;
	}

}

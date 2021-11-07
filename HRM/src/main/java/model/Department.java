package model;

public class Department {

	private Integer id;
	private String depId;
	private String depName;

	public Department(String depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public Department(Integer id, String depId, String depName) {
		super();
		this.id = id;
		this.depId = depId;
		this.depName = depName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}

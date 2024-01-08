package com.jdbc.employee;

public class EmployeeDao {

	private int id;
	private String name;
	private double sal;
	private String loc;
	private long ph_no;
	
	
	
	public EmployeeDao() {
		super();
	}
	
	public EmployeeDao(int id, String name, double sal, String loc, long ph_no) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.loc = loc;
		this.ph_no = ph_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public long getPh_no() {
		return ph_no;
	}
	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	@Override
	public String toString() {
		return "EmployeeDao [id=" + id + ", name=" + name + ", sal=" + sal + ", loc=" + loc + ", ph_no=" + ph_no + "]";
	}
	
	
	
	
}

package model;

public class StudentModel {
	private String rollno;
	private String sname;
	private int sphoneNo;
	private String address;
	private int semester;
	private String cid;
	public StudentModel(String rollno, String sname, int sphoneNo, String address,String cid, int semester) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.sphoneNo = sphoneNo;
		this.address = address;
		this.cid=cid;
		this.semester = semester;
	}
	public StudentModel() {
		super();
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSphoneNo() {
		return sphoneNo;
	}
	public void setSphoneNo(int sphoneNo) {
		this.sphoneNo = sphoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
}

package model;

public class FacultyModel {
	private String fid;
	private String fname;
	private int fphoneNo;
	private String address;
	private String femail;
	private String qualification;
	private int experience;
	public FacultyModel(String fid, String fname, int fphoneNo, String address, String femail, String qualification,int experience) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fphoneNo = fphoneNo;
		this.address = address;
		this.femail = femail;
		this.qualification = qualification;
		this.experience = experience;
	}
	public FacultyModel() {
		super();
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFphoneNo() {
		return fphoneNo;
	}
	public void setFphoneNo(int fphoneNo) {
		this.fphoneNo = fphoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
}

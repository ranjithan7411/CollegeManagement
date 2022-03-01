package model;

public class SubjectModel {
	private String subCode;
	private String subName;
	private int semester;
	private String cid;
	private String fid;
	public SubjectModel(String subCode, String subName, int semester, String cid, String fid) {
		super();
		this.subCode = subCode;
		this.subName = subName;
		this.semester = semester;
		this.cid = cid;
		this.fid = fid;
	}
	public SubjectModel() {
		super();
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	
	

}

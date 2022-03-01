package model;

public class AdminModel {
	private String courseCode;
	private String courseName;
	private int  noOfSubjects;
	private int totalSem;
	
	
	public AdminModel(String courseCode, String courseName, int noOfSubjects, int totalSem) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.noOfSubjects = noOfSubjects;
		this.totalSem = totalSem;
	}
	
	public AdminModel() {
		super();
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfSubjects() {
		return noOfSubjects;
	}
	public void setNoOfSubjects(int noOfSubjects) {
		this.noOfSubjects = noOfSubjects;
	}
	public int getTotalSem() {
		return totalSem;
	}
	public void setTotalSem(int totalSem) {
		this.totalSem = totalSem;
	}
	
}

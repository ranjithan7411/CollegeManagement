package service;

import java.util.ArrayList;

import DAO.CourseDAO;
import model.AdminModel;
import model.FacultyModel;
import model.StudentModel;
import model.SubjectModel;


public  class CourseDetails {
	CourseDAO courseDao = new CourseDAO();
	ArrayList<AdminModel> adminList = new ArrayList<AdminModel>();
	ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();
	ArrayList<FacultyModel> facultyList = new ArrayList<FacultyModel>();
	ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
	public void addCourseToList(AdminModel em) throws ClassNotFoundException {
		adminList.add(em);
		courseDao.storeCourseRecordInDb(adminList);
	}
	public void addStudenToList(StudentModel em) throws ClassNotFoundException {
		studentList.add(em);
		courseDao.storeStudentRecordInDb(studentList);
	}
	public void addFacultyToList(FacultyModel em) throws ClassNotFoundException {
		facultyList.add(em);
		courseDao.storeFacultyRecordInDb(facultyList);
	}
	public void addSubjectToList(SubjectModel em) throws ClassNotFoundException {
		subjectList.add(em);
		courseDao.storeSubjectRecordInDb(subjectList);
	}

}
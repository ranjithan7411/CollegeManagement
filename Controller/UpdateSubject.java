package Controller;

import java.util.Scanner;

import DAO.CourseDAO;

public class UpdateSubject {
	Scanner sc= new Scanner(System.in);
	CourseDAO courseDao= new CourseDAO();
 public void updateSubjctControl() throws ClassNotFoundException {
	 System.out.println("Enter roll number to update existing student Id");
		String subCode = sc.nextLine();
		int option=1;
			System.out.println("Enter the new Student name who has an id as "+subCode);
			String newFid = sc.nextLine();
			//courseDao.updateStudentRecord(option,subCode,newFid);
			System.out.println("updated Successfully");
			
			
 }
}
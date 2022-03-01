package Controller;

import java.util.Scanner;
import DAO.CourseDAO;

interface updateControlInterface{
	void updateStudentControl() throws ClassNotFoundException;
}

public class UpdateControl implements updateControlInterface {
	Scanner sc= new Scanner(System.in);
	CourseDAO courseDao= new CourseDAO();
 public void updateStudentControl() throws ClassNotFoundException {
	 System.out.println("Enter roll number to update existing student Id");
		String rollno = sc.nextLine();
		System.out.println("Select any one of the detail to get updated.\n1) Student Name\n2) Student Phone number\n3) Student Address\n4) Semester\n5) Back ");
		int updateOption = Integer.parseInt(sc.nextLine());
		switch(updateOption) {
		case 1:{
			System.out.println("Enter the new Student name who has an id as "+rollno);
			String newStudentName = sc.nextLine();
			courseDao.updateStudentRecord(updateOption,rollno,newStudentName);
			System.out.println("updated Successfully");
			
			break;
		}
		case 2:{
			System.out.println("Enter the Student new Phone number who has an id as "+rollno);
			int newPhoneNo = Integer.parseInt(sc.nextLine());
			courseDao.updateStudentRecord(updateOption,rollno,newPhoneNo);
			System.out.println("updated Successfully");
			
			break;
		}
		case 3:{
			System.out.println("Enter the student new address who has an id as "+rollno);
			String newStudentName = sc.nextLine();
			courseDao.updateStudentRecord(updateOption,rollno,newStudentName);
			System.out.println("updated Successfully");
			
			break;
		}
		
		case 4:{
			System.out.println("Enter the student new semester who has an id as "+rollno);
			int newSem = Integer.parseInt(sc.nextLine());
			courseDao.updateStudentRecord(updateOption,rollno,newSem);
			System.out.println("updated Successfully");
			
			break;
		}
		case 5:{
			break;
		}
		default:System.out.println("Invalid choice");
		}
 }
}

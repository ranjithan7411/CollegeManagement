package Controller;

import java.util.Scanner;

import DAO.CourseDAO;
import model.AdminModel;
import model.FacultyModel;
import model.StudentModel;
import model.SubjectModel;
import service.CourseDetails;

abstract class Controller{
	 abstract void courseControl() throws ClassNotFoundException;
	 abstract void subjectControl() throws ClassNotFoundException;
	 abstract void studentControl() throws ClassNotFoundException;
	 abstract void facultyControl() throws ClassNotFoundException;
}

public class CourseController extends Controller {
	CourseDAO courseDao = new CourseDAO();
	CourseDetails cd= new CourseDetails();
	Scanner sc= new Scanner(System.in);

 public void courseControl() throws ClassNotFoundException {
	 System.out.println("1) View Course Details\n2) Add Course\n3) Remove Course\n4) Back\n");
	 Scanner sc= new Scanner(System.in);
		int courseChoice = Integer.parseInt(sc.nextLine());
		switch(courseChoice) {
			case 1: {
				courseDao.viewCourseRecord();
				courseControl();
				break;
				
			}
			case 2:{
				System.out.println("Enter the details to add course ");
				String courseId;
				String courseName;
				int totalSub;
				int totalSem;
				int result=0;
				System.out.println("Enter the course id");
				courseId = sc.nextLine();
				System.out.println("Enter the course Name");
					courseName = sc.nextLine();
				System.out.println("Enter the total subjects in that course");
					totalSub =Integer.parseInt(sc.nextLine());
				System.out.println("Enter the total semester");
					totalSem = Integer.parseInt(sc.nextLine());
					AdminModel em = new AdminModel(courseId,courseName,totalSub,totalSem);
					cd.addCourseToList(em);
				
				courseControl();
				break;
			}
			case 3:{
				System.out.println("enter the course to delete");
				String courseId = sc.nextLine();
				AdminModel em = new AdminModel();
				courseDao.deleteCourseRecordInDb(courseId);
				courseControl();
				break;
			}
			case 4:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			courseControl();
			
			break;

		}
 	}
 //for subject
 public void subjectControl() throws ClassNotFoundException {
	 System.out.println("1) View Subject\n2) Add subject\n3) Remove subject\n4) Back\n");
	 Scanner sc= new Scanner(System.in);
		int courseChoice = Integer.parseInt(sc.nextLine());
		switch(courseChoice) {
			case 1: {
				courseDao.viewSubjectRecord();
				subjectControl();
				break;
				
			}
			case 2:{
				System.out.println("Enter the details to add Subject");
				String subCode;
				String subName;
				int semester;
				String cid;
				String fid;
				
				int result=0;
				
				System.out.println("Enter Subject code ");
					subCode = sc.nextLine();
					System.out.println("Enter Subject Name ");
					subName = sc.nextLine();
					System.out.println("Enter the semester ");
					semester =Integer.parseInt(sc.nextLine());
					System.out.println("Enter Course id ");
					cid = sc.nextLine();
					System.out.println("Enter Faculty id ");
					fid = sc.nextLine();
					
					
					SubjectModel em1 = new SubjectModel(subCode,subName,semester,cid,fid);
					cd.addSubjectToList(em1);
				subjectControl();
				break;
			}
			case 3:{
				System.out.println("enter the subject code to delete");
				String subCode = sc.nextLine();
				SubjectModel em = new SubjectModel();
				courseDao.deleteSubjectRecordInDb(subCode);
				subjectControl();
				break;
			}
			
			case 4:{
			//	temp=false;
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			subjectControl();

		}
	 	
 }
 
 //for student in main controller
 public void studentControl() throws ClassNotFoundException {
	 System.out.println("1) View Student Details\n2) Add student\n3) Remove student\n4) Edit Student\n5) Back\n");
	 Scanner sc= new Scanner(System.in);
		int courseChoice = Integer.parseInt(sc.nextLine());
		switch(courseChoice) {
			case 1: {
				courseDao.viewStudentRecord();
				studentControl();
				break;
				
			}
			case 2:{
				System.out.println("enter the details to add student");
				String rollno;
				String sname;
				int sphoneNo;
				String address;
				String cid;
				int sem;
				int result=0;
				System.out.println("Enter Roll number");
					rollno = sc.nextLine();
					System.out.println("Enter Student Name");
					sname = sc.nextLine();
					System.out.println("Enter Student phone number");
					sphoneNo =Integer.parseInt(sc.nextLine());
					System.out.println("Enter Student Address");
					address = sc.nextLine();
					System.out.println("Enter course Id");
					cid = sc.nextLine();
					System.out.println("Enter Semester");
					sem = Integer.parseInt(sc.nextLine());
					
					StudentModel em1 = new StudentModel(rollno, sname, sphoneNo, address,cid, sem);
					cd.addStudenToList(em1);
				studentControl();
				break;
			}
			case 3:{
				System.out.println("enter the Roll number to delete");
				String rollno = sc.nextLine();
				StudentModel em = new StudentModel();
				courseDao.deleteStudentRecordInDb(rollno);
				studentControl();
				break;
			}
			case 4:{
				UpdateControl uc=new UpdateControl();
				uc.updateStudentControl();
				studentControl();
				break;
				}
			case 5:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			studentControl();

		}
 }
 public void facultyControl() throws ClassNotFoundException {
	 System.out.println("1) View Faculty Details\n2) Add Faculty \n3) Remove Faculty\n4) Back\n");
	 Scanner sc= new Scanner(System.in);
		int courseChoice = Integer.parseInt(sc.nextLine());
		switch(courseChoice) {
			case 1: {
				courseDao.viewFacultyRecord();
				facultyControl();
				break;
				
			}
			case 2:{
				/*System.out.println("enter the fid to view the subject");
				String fid = sc.nextLine();
				courseDao.viewFacultyRecord(fid);
				facultyControl();*/
				String fid;
				String fname;
				int phoneNo;
				String address;
				String email;
				String qualification;
				int experience;
				int result=0;
				//for(int i=0; i<courseCount; i++) {
				System.out.println("Enter Faculty id");
					fid = sc.nextLine();
					System.out.println("Enter Faculty Name");
					fname = sc.nextLine();
					System.out.println("Enter Faculty phone number");
					phoneNo =Integer.parseInt(sc.nextLine());
					System.out.println("Enter Faculty Address");
					address = sc.nextLine();
					System.out.println("Enter Faculty Email");
					email = sc.nextLine();
					System.out.println("Enter Faculty Qualification");
					qualification = sc.nextLine();
					System.out.println("Enter Experience");
					experience = Integer.parseInt(sc.nextLine());
					
					FacultyModel em1 = new FacultyModel(fid, fname, phoneNo, address,email,qualification,experience);
					cd.addFacultyToList(em1);
				//}
				facultyControl();
				break;
				
				
				
			}
			case 3:{
				System.out.println("enter the Faculty id to delete");
				String fid = sc.nextLine();
				FacultyModel em = new FacultyModel();
				courseDao.deleteFacultyRecordInDb(fid);
				facultyControl();
				break;
			}
			
			case 4:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			facultyControl();

		}
 }

}
		

		
 
 

package Controller;

import java.util.Scanner;

import DAO.CourseDAO;

import model.StudentModel;



public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
	
		CourseDAO courseDao = new CourseDAO();
		System.out.println("=============================================");
		System.out.println("            COLLEGE MANAGEMENT SYSTEM         ");
		System.out.println("=============================================");
		boolean temp = true;
		while(temp) {
			System.out.println("1) Admin \n2) Faculty\n3) Student");
			Scanner sc = new Scanner(System.in);
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
				case 1: {
					System.out.println("Enter your username");
					String adminName = sc.nextLine();
					System.out.println("Enter your password");
					String adminPwd = sc.nextLine();
					if(adminName.equals("admin") && adminPwd.equals("admin")) {
						boolean temp1 = true;
						while(temp1) {
							System.out.println("Choose any one of an operation that you wish to do");
							System.out.println("1) Course\n2) Subjects\n3) Students\n4) Faculty\n5) Back");
							boolean flag1 = true;
							int adminOption = 0;
							while(flag1) {
								try {
									adminOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println("Invalid input. enter the valid input");
									flag1 =true;
								}
							}							
							switch(adminOption) {
								case 1:{	
									CourseController cc=new CourseController();
									cc.courseControl();
									break;
									}
								
								case 2:{
									CourseController cc1=new CourseController();
									cc1.subjectControl();
									break;
								}
								case 3:{
									CourseController cc2=new CourseController();
									cc2.studentControl();
									break;
									}
								case 4:{
									CourseController cc3=new CourseController();
									cc3.facultyControl();
									break;
									}
							
								case 5:{
									temp1 = false;
									break;
								}
								default:System.out.println("Invalid choice............ ");
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
				case 2:{
					System.out.println("Enter your username");
					String adminName = sc.nextLine();
					System.out.println("Enter your password");
					String adminPwd = sc.nextLine();
					if(adminName.equals("faculty") && adminPwd.equals("faculty")) {
						boolean temp1 = true;
						
						while(temp1) {
							System.out.println("Choose any one of an operation that you wish to do");
							System.out.println("1) View Students\n2) View assigned Subject\n3) Markss\n4) Back");
							boolean flag1 = true;
							int adminOption = 0;
							while(flag1) {
								try {
									adminOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println("Invalid input. enter the valid input");
									flag1 =true;
								}
							}
							
							switch(adminOption) {
								case 1:{	
									CourseController cc=new CourseController();
									courseDao.viewStudentRecord();
									temp=false;
									break;
									}
								
								case 2:{
									CourseController cc1=new CourseController();
									System.out.println("enter faculty id to view subject");
									String fid=sc.nextLine();
									courseDao.viewFacultyRecord(fid);
									temp=false;
									break;
								}
								case 3:{
									CourseController cc2=new CourseController();
									System.out.println("do you want to Add student marks (yes/no)?");
									String op=sc.nextLine();
									if(op.equalsIgnoreCase("yes")) {
									System.out.println("Enter roll no to add marks");
									String rollno=sc.nextLine();
									System.out.println("Enter marks of 3 subjects");
									int m1=Integer.parseInt(sc.nextLine());
									int m2=Integer.parseInt(sc.nextLine());
									int m3=Integer.parseInt(sc.nextLine());
									courseDao.storeMarksTable(rollno, m1,m2,m3);
									}
									System.out.println("do you want to view all the student marks (yes/no)?");
									op=sc.nextLine();
									if(op.equalsIgnoreCase("yes")) {
									courseDao.viewMarksRecord();
									}
									temp=false;
									break;
									}
								
							
								case 4:{
									temp1 = false;
									break;
								}
								default:System.out.println("Invalid choice..............");
								break;
								
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
				case 3:{
					System.out.println("Enter your username");
					String adminName = sc.nextLine();
					System.out.println("Enter your password");
					String adminPwd = sc.nextLine();
					if(adminName.equals("student") && adminPwd.equals("student")) {
						boolean temp1 = true;
						
						while(temp1) {
							System.out.println("Choose any one of an operation that you wish to do");
							System.out.println("1) View Students\n2) View Faculty\n3) View Marks\n4) Back");
							boolean flag1 = true;
							int adminOption = 0;
							while(flag1) {
								try {
									adminOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println("Invalid input. enter the valid input");
									flag1 =true;
								}
							}
							
							switch(adminOption) {
								case 1:{	
									CourseController cc=new CourseController();
									courseDao.viewStudentRecord();
									temp=false;
									break;
									}
								
								case 2:{
									courseDao.viewFacultyRecord();
									temp=false;
									break;
								}
								case 3:{
									courseDao.viewMarksRecord();
									temp=false;
									break;
									}
								case 4:{
									temp1=false;
									break;
								}
								default:System.out.println("Invalid choice..........");
								temp=false;
								break;
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
					
				
				default:{
					System.out.println("Invalid Choice............");
				}
		}
	}
		}
	
}
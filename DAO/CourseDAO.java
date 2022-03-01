package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AdminModel;
import model.FacultyModel;
import model.StudentModel;
import model.SubjectModel;
import utility.ConnectionManager;

public class CourseDAO extends GetConnection{

	Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	//to insert the coursedetails to couse table
	public void storeCourseRecordInDb(ArrayList<AdminModel> empList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into course(cid,cname,totalSub,totalSem) values (?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(AdminModel em: empList) {
				ps.setString(1, em.getCourseCode());
				ps.setString(2, em.getCourseName());
				ps.setInt(3, em.getNoOfSubjects());
				ps.setInt(4, em.getTotalSem());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Course details added successfully.....");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
		//to delete the course
		public void deleteCourseRecordInDb(String courseId)  throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "delete from course where cid=?";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				//for(AdminModel em: empList) {
				 AdminModel em= new AdminModel();
					ps.setString(1, courseId);
				int result = ps.executeUpdate();
				if(result==1) {
				System.out.println("Course Details deleted Successfully.....");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
	}
	
	public void viewCourseRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from course";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("==========================================================================");
			System.out.format("%-10s %-25s %-12s %-13s\n","Course Id","Course Name", "TotalSubject","TotalSemester");
			System.out.println("==========================================================================");
			while(rs.next()) {
				
				System.out.format("%-10s %-25s %-15s %-11s\n",rs.getString(1), rs.getString(2), rs.getInt(3),rs.getInt(4));
				
			}
			System.out.println("==========================================================================");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

		
	//view subject record
	public void viewSubjectRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from subject";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("===========================================================================================");
			System.out.format("%-15s %-20s %-15s %-15s %-15s\n","SubjectCode","SubjectName","Semester","CourseId","FacultyID" );
			System.out.println("===========================================================================================");
			while(rs.next()) {
				System.out.format("%-15s %-20s %-15s %-15s %-15s\n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				
			}
			System.out.println("===========================================================================================");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void storeSubjectRecordInDb(ArrayList<SubjectModel> facultyList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into subject(subCode,subName,semester,cid,fid) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(SubjectModel em: facultyList) {
				ps.setString(1, em.getSubCode());
				ps.setString(2, em.getSubName());
				ps.setInt(3, em.getSemester());
				ps.setString(4, em.getCid());
				ps.setString(5, em.getFid());
				
				//ps.setDouble(5, em.getEmployeeSalary());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Subject details are added successfully.....");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
		//to delete the subject
		public void deleteSubjectRecordInDb(String subCode)  throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "delete from subject where subCode=?";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				//for(AdminModel em: empList) {
				SubjectModel em= new SubjectModel();
					ps.setString(1, subCode);
				int result = ps.executeUpdate();	
				System.out.println("Deleted Successful.....");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


//for Students in course controller
	public void viewStudentRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from student";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("====================================================================================================================");
			System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n","RollNo","StudentName","PhoneNumber","Address","Course","Semester");
			System.out.println("====================================================================================================================");
			while(rs.next()) {
				System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6));				
			}
			System.out.println("====================================================================================================================");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void storeStudentRecordInDb(ArrayList<StudentModel> studentList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into student(rollno,sname,sphoneNo,address,cid,semester) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(StudentModel em: studentList) {
				ps.setString(1, em.getRollno());
				ps.setString(2, em.getSname());
				ps.setInt(3, em.getSphoneNo());
				ps.setString(4, em.getAddress());
				ps.setString(5, em.getCid());
				ps.setInt(6, em.getSemester());
				//ps.setDouble(5, em.getEmployeeSalary());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Student details added successfully.....");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
		//to delete the course
		public void deleteStudentRecordInDb(String rollno)  throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "delete from student where rollno=?";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				//for(AdminModel em: empList) {
				StudentModel em= new StudentModel();
					ps.setString(1, rollno);
				int result = ps.executeUpdate();	
				System.out.println("Student Records Deleted Successfully.....");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		public void updateStudentRecord(int option, String rollno, String newEmpDetail) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = null;
			if(option == 1) {
				sql = "update student set sname = ? where rollno = ?";	
			}
			else if(option == 3) {
				sql = "update student set address = ? where rollno = ?";	
			}
			
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				ps.setString(1, newEmpDetail);
				ps.setString(2, rollno);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void updateStudentRecord(int option, String rollno, int newstudentDetails) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql=null;
			if(option == 2) {
				sql = "update student set sphoneNo = ? where rollno = ?";	
			}
			else if(option == 4) {
				sql = "update student set semester = ? where rollno = ?";	
			}
			
			
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				ps.setInt(1, newstudentDetails);
				ps.setString(2,rollno);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

		//for Faculty in course controller
		public void viewFacultyRecord() throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "Select * from faculty";
			try {
				Statement stmt = dbConn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("====================================================================================================================================================");
				System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","FacultyId","FacultyName","PhoneNumber","Address","Email","Qualification","Experience");
				System.out.println("====================================================================================================================================================");
				while(rs.next()) {
					System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",rs.getString(1),rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));				
				}
				System.out.println("====================================================================================================================================================");
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//to view faculty subjects 
		public void viewFacultyRecord(String fid) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "Select fid, subCode,subname from subject where fid=?";
			try {
				PreparedStatement ps= dbConn.prepareStatement(sql);
				ps.setString(1, fid);
				ResultSet rs = ps.executeQuery();
				System.out.println("=====================================================================");
				System.out.format("%-20s %-20s %-20s\n","FacultyId", "SubjectCode","SubjectName");
				System.out.println("=====================================================================");
				while(rs.next()) {
					System.out.format("%-20s %-20s %-20s\n",rs.getString(1),rs.getString(2),rs.getString(3));				
				}
				System.out.println("=====================================================================");
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void storeFacultyRecordInDb(ArrayList<FacultyModel> facultyList) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "insert into faculty(fid,fname,fphoneNo,address,femail,qualification,experience) values (?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				for(FacultyModel em: facultyList) {
					ps.setString(1, em.getFid());
					ps.setString(2, em.getFname());
					ps.setInt(3, em.getFphoneNo());
					ps.setString(4, em.getAddress());
					ps.setString(5, em.getFemail());
					ps.setString(6, em.getQualification());
					ps.setInt(7, em.getExperience());
					//ps.setDouble(5, em.getEmployeeSalary());
					int result = ps.executeUpdate();
					if(result == 1) {
						System.out.println("Student details added successfully.....");
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
			
			//to delete the course
			public void deleteFacultyRecordInDb(String fid)  throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = "delete from faculty where fid=?";
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					//for(AdminModel em: empList) {
					StudentModel em= new StudentModel();
						ps.setString(1, fid);
					int result = ps.executeUpdate();	
					System.out.println("Deleted Successful.....");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

			public void updateFacultyRecord(int option, String rollno, String newEmpDetail) throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = null;
				if(option == 1) {
					sql = "update student set sname = ? where rollno = ?";	
				}
				else if(option == 3) {
					sql = "update student set address = ? where rollno = ?";	
				}
				
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					ps.setString(1, newEmpDetail);
					ps.setString(2, rollno);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void updateFacultyRecord(int option, String rollno, int newstudentDetails) throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql=null;
				if(option == 2) {
					sql = "update student set sphoneNo = ? where rollno = ?";	
				}
				else if(option == 4) {
					sql = "update student set semester = ? where rollno = ?";	
				}
				
				
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					ps.setInt(1, newstudentDetails);
					ps.setString(2,rollno);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			//for marks
			public void storeMarksTable(String rollno, int m1, int m2, int m3 ) throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = "insert into Marks(rollno,ComputerNetwork,Python,Java) values (?,?,?,?)";
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					
						ps.setString(1, rollno);
						ps.setInt(2, m1);
						ps.setInt(3, m2);
						ps.setInt(4, m3);
						
						//ps.setDouble(5, em.getEmployeeSalary());
						int result = ps.executeUpdate();
						if(result == 1) {
							System.out.println("Marks details added successfully.....");
						}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void viewMarksRecord() throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = "Select * from Marks";
				try {
					Statement stmt = dbConn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					System.out.println("======================================================================================");
					System.out.format("%-20s %-20s %-20s %-20s\n","Rollno","Computer Networks","Java","Python");
					System.out.println("======================================================================================");
					while(rs.next()) {
						System.out.format("%-20s %-20s %-20s %-20s\n",rs.getString(1),rs.getInt(2), rs.getInt(3),rs.getInt(4));				
					}
					System.out.println("======================================================================================");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

}
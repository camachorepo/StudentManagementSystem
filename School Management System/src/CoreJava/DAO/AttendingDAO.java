package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {

    public List<Attending> getAttending(){
    	ArrayList <Attending> attendingStudents = new ArrayList <Attending>();
    	String path = "C:\\Users\\Students\\James_Workspace\\School Management System\\attending.csv";
    	File file = new File (path);
    	
    	try {
			Scanner sc  = new Scanner (file);
			while (sc.hasNextLine()) {
				String[] info = sc.nextLine().split(","); 
				Attending student = new Attending();
				
				student.setCourseID(Integer.parseInt(info[0]));
				student.setStudentEmail(info[1]);
				
				attendingStudents.add(student);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("attending.csv fiele not found");
		}
    	
    	return attendingStudents;
    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID){
    	Boolean foundDuplicate = false;
    	for(Attending a: attending ) {
    		
    		if (a.getStudentEmail().equals(studentEmail) && (a.getCourseID() == courseID)) foundDuplicate = true;
    	}
    	
    	if (!foundDuplicate)
    	{
    		Attending student = new Attending (); 
    		student.setCourseID(courseID);
    		student.setStudentEmail(studentEmail);
    		
    		attending.add(student);
    		saveAttending(attending);
    	}
    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){

    	ArrayList <Course> matchingCourses = new ArrayList<Course>();
    	ArrayList<Integer> courseIDS = new ArrayList<Integer>();
    	
    	//Find all courses student is attending by email
    	for (Attending a : attending) {
    		
    		if(a.getStudentEmail().equals(studentEmail)) courseIDS.add(a.getCourseID());
    		}
    	
    	//Find all course info for every matching course id
    	for (Integer i : courseIDS) {
    		
    		
    		for (Course c : courseList) {
    			
    			if (c.getID() == i) matchingCourses.add(c);
    		}
    		
    		
    	}
    	
    	//return all the courses this student is attending
    	return matchingCourses;
    }

    public void saveAttending(List<Attending> attending){
    	String path = "C:\\Users\\Students\\James_Workspace\\School Management System\\attending.csv";
    	File file = new File(path);
    	FileWriter attendingFile;
    	
    	try {
			attendingFile = new FileWriter(file, false);
			
			// for every Attending object write that info to the attending.csv file
			for (Attending a : attending) {
				
				// make sure the courseid and student email is separated by a comma delimiter
				attendingFile.write(a.getCourseID() + ",");
				// make sure a new line is inserted after ever Attending object 
				attendingFile.write(a.getStudentEmail() + "\r\n");
				
			}
			// always close the FileWriter 
			attendingFile.close();
			
		} catch (IOException e) {
			System.out.println("Cannot save attending students to attending.csv");
		}
    	
    }

}

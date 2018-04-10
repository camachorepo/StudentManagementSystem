package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    public List<Student>  getStudents(){
    	ArrayList <Student> students = new ArrayList<Student>();
    	String path = "C:\\Users\\Students\\James_Workspace\\School Management System\\students.csv";
    	File studentFile = new File(path);
    	
    	try {
			Scanner sc = new Scanner (studentFile);
			while(sc.hasNextLine()) {
				
				Student newStudent = new Student(); 
				String [] info = sc.nextLine().split(",");
				newStudent.setEmail(info[0]);
				newStudent.setName(info[1]);
				newStudent.setPass(info[2]);
				
				students.add(newStudent);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("studesnts.csv file not found");
		}
    	
    	
    	return students;
    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	
    	Student gotStudent = new Student();
    	for(Student s : studentList) {
    		
    		if(s.getEmail().equals(studentEmail)) {
    			gotStudent = s;
    			break;
    		}
    	}
    	
    	return gotStudent;
    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	boolean studentFound = false;
    	for(Student s : studentList) {
    		if(s.getEmail().equals(studentEmail) && s.getPass().equals(studentPass)) studentFound = true;
    		
    	}
    	
    	return studentFound;
    }
}

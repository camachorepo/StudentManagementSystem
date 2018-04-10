package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
    public List<Course> getAllCourses(){
    	ArrayList <Course> courses = new ArrayList <Course>();
    	String path = "C:\\Users\\Students\\James_Workspace\\School Management System\\courses.csv";
    	
    	File file = new File (path);
    	
    	try {
			Scanner sc = new Scanner (file);
			while(sc.hasNextLine()) {
				String[] info = sc.nextLine().split(",");
				Course newCourse = new Course();
				newCourse.setID(Integer.parseInt(info[0]));
				newCourse.setName(info[1]);
				newCourse.setInstructor(info[2]);
				
				courses.add(newCourse);
				
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("courses.csv file not found");
		}
    	
    	return courses;

    }
}

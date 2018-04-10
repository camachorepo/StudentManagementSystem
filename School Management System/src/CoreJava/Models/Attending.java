package CoreJava.Models;

public class Attending {

	private int courseID; 
	private String studentEmail;
	
    public void setCourseID(int courseID){
    	this.courseID = courseID;
    }

    public int getCourseID(){
    	return this.courseID;
    }

    public void setStudentEmail(String studentEmail){
    	this.studentEmail = studentEmail;
    }

    public String getStudentEmail(){
    	return this.studentEmail;
    }
}

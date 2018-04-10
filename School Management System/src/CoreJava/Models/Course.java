package CoreJava.Models;

public class Course {

	private int id; 
	private String name; 
	private String instructor;
	
    public void setID(int ID){
    	this.id = ID;
    }

    public int getID(){
    	return this.id;
    }

    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return this.name;
    }

    public void setInstructor(String instructor){
    	this.instructor = instructor;
    }

    public String getInstructor(){
    	return this.instructor;
    }

}

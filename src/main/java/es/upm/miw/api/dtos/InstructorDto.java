package es.upm.miw.api.dtos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.upm.miw.api.entities.Instructor;

public class InstructorDto {
    private int id;
    private String firstName;
    private String lastName;
    private Calendar hireDate;
    private CourseDto course;
    
    
    public InstructorDto(){
        
    }
    
    public InstructorDto(Instructor instructor){
        
        this.id = instructor.getId();
        this.firstName = instructor.getFirstName();
        this.lastName = instructor.getLastName();
        this.hireDate = Calendar.getInstance();
        this.course = new CourseDto(instructor.getCourse());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    @Override
    public String toString() {
        
        String formattedDate = new SimpleDateFormat(" dd-MMM-yyyy ").format(hireDate.getTime());
        return "{\"id\":" + id + ", \"firstName\":\"" + firstName + ", \"lastName\":\"" + lastName + ", \"hireDate\":\"" + formattedDate + ", \"course\":\""+ course + "\"}";
    }
    
}

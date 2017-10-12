package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Instructor;

public class InstructorDto {
    private int id;
    private String firstName;
    private String lastName;
    
    public InstructorDto(Instructor instructor){
        
        this.id = instructor.getId();
        this.firstName = instructor.getFirstName();
        this.lastName = instructor.getLastName();
   
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
    
    @Override
    public String toString() {
        return "{\"id\":" + id + ", \"firstName\":\"" + firstName + ", \"lastName\":\"" + lastName + "\"}";
    }
    
}

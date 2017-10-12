package es.upm.miw.api.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Instructor {
    
    private int id;
    private String firstName;
    private String lastName;
    private Calendar hireDate;
    
    public Instructor() {
        
    }

    
    public Instructor( String firstName){
        this.firstName = firstName;
        this.hireDate = Calendar.getInstance();
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

    @Override
    public String toString() {
        
        String formattedDate = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(hireDate.getTime());
        return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate=" + formattedDate + "]";
    }

}

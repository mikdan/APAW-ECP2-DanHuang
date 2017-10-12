package es.upm.miw.api.resources;

import java.util.Calendar;

import es.upm.miw.api.controllers.InstructorController;
import es.upm.miw.api.dtos.InstructorDto;
import es.upm.miw.api.resources.exceptions.CourseIdNotFoundException;
import es.upm.miw.api.resources.exceptions.FieldInvalidException;

public class InstructorResource {
    
    public static final String Instructor = "instructor";
    
    public static final String ID = "/{id}";
    
    public void createInstructor(String firstName, String lastName, Calendar hireDate, Integer idCourse)
            throws FieldInvalidException, CourseIdNotFoundException {
        this.validateObligatoryFields(firstName, lastName, hireDate);
        if (!new InstructorController().createInstructor(firstName, lastName, hireDate, idCourse)) {
            throw new CourseIdNotFoundException(Integer.toString(idCourse));
        }
    }

    private void validateObligatoryFields(String firstName, String lastName, Calendar hireDate) throws FieldInvalidException {
        
        if (firstName == null || firstName.isEmpty()) {
            throw new FieldInvalidException();
        } else if (lastName == null || lastName.isEmpty()) {
            throw new FieldInvalidException();
        } else if (hireDate == null) {
            throw new FieldInvalidException();
        }
        
    }
    
    public InstructorDto deleteInstructor(int id) {
        return new InstructorController().deleteInstructor(id);
        
    }
    
    

}

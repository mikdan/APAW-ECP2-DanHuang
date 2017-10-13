package es.upm.miw.api.resources;

import java.util.Calendar;
import java.util.Optional;

import es.upm.miw.api.controllers.CourseController;
import es.upm.miw.api.controllers.InstructorController;
import es.upm.miw.api.dtos.CourseDto;
import es.upm.miw.api.dtos.InstructorDto;
import es.upm.miw.api.resources.exceptions.CourseIdNotFoundException;
import es.upm.miw.api.resources.exceptions.FieldInvalidException;
import es.upm.miw.api.resources.exceptions.InstructorIdNotFoundException;

public class InstructorResource {
    
    public static final String INSTRUCTOR = "instructor";
    
    public static final String ID = "/{id}";
    
    public void createInstructor(String firstName, String lastName, Calendar hireDate, Integer idCourse)
            throws FieldInvalidException, CourseIdNotFoundException {
        this.validateObligatoryFields(firstName, lastName, hireDate);
        if (!new InstructorController().createInstructor(firstName, lastName, hireDate, idCourse)) {
            throw new CourseIdNotFoundException(Integer.toString(idCourse));
        }
    }
    
    public InstructorDto readInstructor(int id) throws InstructorIdNotFoundException {
        Optional<InstructorDto> optional =  new InstructorController().readInstructor(id);
        return optional.orElseThrow(()->new InstructorIdNotFoundException(Integer.toString(id)));
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

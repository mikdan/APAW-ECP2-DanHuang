package es.upm.miw.api.controllers;

import java.util.Optional;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.InstructorDto;
import es.upm.miw.api.entities.Course;
import es.upm.miw.api.entities.Instructor;

public class InstructorController {
    
    public boolean createInstructor(String firstName, String  lastName, int idCourse){
        
        Course course = DaoFactory.getFactory().getCourseDao().read(idCourse);
        if (course != null) {
            Instructor instructor = new Instructor(firstName, lastName, course);
            DaoFactory.getFactory().getInstructorDao().create(instructor);
            return true;
        } else {
            return false;
        }
           
    }
    
    private boolean exitInstructor(int id) {
        return DaoFactory.getFactory().getInstructorDao().read(id) != null;
    }
    
    public Optional<InstructorDto> readInstructor(int id) {
        if (exitInstructor(id)) {
            return Optional.of(new InstructorDto(DaoFactory.getFactory().getInstructorDao().read(id)));
        } else {
            return Optional.empty();
        }
    }
}

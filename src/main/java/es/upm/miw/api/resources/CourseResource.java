package es.upm.miw.api.resources;

import java.util.Optional;

import es.upm.miw.api.controllers.CourseController;
import es.upm.miw.api.dtos.CourseDto;
import es.upm.miw.api.dtos.InstructorsCourseDto;
import es.upm.miw.api.resources.exceptions.CourseExistException;
import es.upm.miw.api.resources.exceptions.CourseFieldInvalidException;
import es.upm.miw.api.resources.exceptions.CourseIdNotFoundException;

public class CourseResource {
    
    public static final String COURSE= "course";

    public static final String ID = "/{id}";

    public static final String ID_INSTRUCTOR = ID + "/instructor";
    
    public CourseDto readCourse(int id) throws CourseIdNotFoundException {
        Optional<CourseDto> optional =  new CourseController().readCourse(id);
        return optional.orElseThrow(()->new CourseIdNotFoundException(Integer.toString(id)));
    }
    
    public void createCourse(String title, int credits) throws CourseExistException, CourseFieldInvalidException {
        this.validateFileds(title, credits);
        if (new CourseController().isExited(title, credits)) {
            throw new CourseExistException("title:" + title + ",credits:" + credits);
        }
        new CourseController().createCourse(title,credits);
    }

    private void validateFileds(String title, int credits) throws CourseFieldInvalidException {
        // TODO Auto-generated method stub
        if (title == null || title.isEmpty()) {
            throw new CourseFieldInvalidException(title);
        }
        if (credits < 1) {
            throw new CourseFieldInvalidException("credits");
        }
        
    }
    
    public InstructorsCourseDto readInstructorCourse(int id) throws CourseIdNotFoundException {
        Optional<InstructorsCourseDto> optional = new CourseController().readInstructorsCourse(id);
        return optional.orElseThrow(()->new CourseIdNotFoundException(Integer.toString(id)));
    }

}

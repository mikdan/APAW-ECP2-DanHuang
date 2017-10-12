package es.upm.miw.api.resources;

import java.util.Optional;

import es.upm.miw.api.controllers.CourseController;
import es.upm.miw.api.dtos.CourseDto;
import es.upm.miw.api.resources.exceptions.CourseIdNotFoundException;

public class CourseResource {
    
    public static final String COURSE= "course";

    public static final String ID = "/{id}";

    public static final String ID_INSTRUCTOR = ID + "/instructor";
    
    public CourseDto readSubject(int id) throws CourseIdNotFoundException {
        Optional<CourseDto> optional =  new CourseController().readCourse(id);
        return optional.orElseThrow(()->new CourseIdNotFoundException(Integer.toString(id)));
    }

}

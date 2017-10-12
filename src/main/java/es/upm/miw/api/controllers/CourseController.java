package es.upm.miw.api.controllers;

import java.util.Optional;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.CourseDto;
import es.upm.miw.api.entities.Course;

public class CourseController {
    
    public void createCourse(String title, int credits){
        DaoFactory.getFactory().getCourseDao().create(new Course(title, credits));
    }
    
    private boolean exitCourseId(int id){
        return DaoFactory.getFactory().getCourseDao().read(id) != null;
    }
    
    public Optional<CourseDto> readCourse(int id) {
        if (exitCourseId(id)) {
            return Optional.of(new CourseDto(DaoFactory.getFactory().getCourseDao().read(id)));
        } else {
            return Optional.empty();
        }
    }
    
    

}

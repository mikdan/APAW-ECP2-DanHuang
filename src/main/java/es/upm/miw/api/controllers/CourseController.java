package es.upm.miw.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.CourseDto;
import es.upm.miw.api.dtos.InstructorDto;
import es.upm.miw.api.dtos.InstructorsCourseDto;
import es.upm.miw.api.entities.Course;
import es.upm.miw.api.entities.Instructor;

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
    
    
    public Optional<InstructorsCourseDto> readInstructorsCourse(int id) {
        
        if (exitCourseId(id)) {
            CourseDto course = new CourseDto(DaoFactory.getFactory().getCourseDao().read(id));
            List<Instructor>  instructorAux = DaoFactory.getFactory().getInstructorDao().findAll();
            List<InstructorDto> instructorListDto = new ArrayList<InstructorDto>();
            for (Instructor item : instructorAux) {
                if (item.getCourse().getId() == course.getId()) {
                    instructorListDto.add(new InstructorDto(item));
                }
            }
            return Optional.of(new InstructorsCourseDto(course,instructorListDto));
        } else {
            return Optional.empty();
        }
    }
    
    public Boolean isExited(String title, int credits) {
        
        Boolean res = false;
        List<Course> courses = DaoFactory.getFactory().getCourseDao().findAll();
        for (Course item : courses) {
            if (item.getTitle().toUpperCase().equals(title.toUpperCase()) && item.getCredits() == credits) {
                res = true;
                break;
            }
        }
        return res;
    }
    
    

}

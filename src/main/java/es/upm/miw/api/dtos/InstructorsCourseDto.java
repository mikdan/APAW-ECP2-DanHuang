package es.upm.miw.api.dtos;

import java.util.List;

public class InstructorsCourseDto {
    
    private CourseDto course;
    
    private List<InstructorDto> listInstructor;

    public InstructorsCourseDto(CourseDto course, List<InstructorDto> listInstructor) {
        super();
        this.course = course;
        this.listInstructor = listInstructor;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public List<InstructorDto> getListInstructor() {
        return listInstructor;
    }

    public void setListInstructor(List<InstructorDto> listInstructor) {
        this.listInstructor = listInstructor;
    }

    @Override
    public String toString() {
        String res = "{" + course.toString() + "[";
        boolean first = true;
        for (InstructorDto item : listInstructor ) {
            if (!first)
                res = res + ",";            
            res = res + item.toString();
            first = false;
        }
        res = res + "]}";
        return res;
       
    }
    
    
    

}

package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Course;

public class CourseDto {
    
    private int id;
    private String title;
    private int credits;
    
    public CourseDto(Course course){
        this.id= course.getId();
        this.title=course.getTitle();
        this.credits = course.getCredits();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"title\":" + title + ",\"credits\":" + credits + "}";
    }
    
    
    
    

}

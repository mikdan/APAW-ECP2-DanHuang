package es.upm.miw.api.resources.exceptions;

public class CourseIdNotFoundException extends Exception {
    
    private static final long serialVersionUID =  -1L;

    public static final String DESCRIPTION = "El id del curso no existe";

    public CourseIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CourseIdNotFoundException() {
        this("");
    }

}

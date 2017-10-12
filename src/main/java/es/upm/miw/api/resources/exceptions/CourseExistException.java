package es.upm.miw.api.resources.exceptions;

public class CourseExistException extends Exception {
    
    private static final long serialVersionUID =  -1L;

    public static final String DESCRIPTION = "El curso existe";

    public CourseExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CourseExistException() {
        this("");
    }


}

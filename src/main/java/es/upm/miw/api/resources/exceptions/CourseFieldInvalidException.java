package es.upm.miw.api.resources.exceptions;

public class CourseFieldInvalidException extends Exception {
    
    private static final long serialVersionUID =  -1L;

    public static final String DESCRIPTION = "fuera del rango";

    public CourseFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CourseFieldInvalidException() {
        this("");
    }

    
}

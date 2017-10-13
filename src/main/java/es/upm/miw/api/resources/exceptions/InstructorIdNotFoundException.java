package es.upm.miw.api.resources.exceptions;

public class InstructorIdNotFoundException extends Exception {
    
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del tema no existe";

    public InstructorIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InstructorIdNotFoundException() {
        this("");
    }

}

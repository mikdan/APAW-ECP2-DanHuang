package es.upm.miw.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.upm.miw.api.resources.CourseResource;
import es.upm.miw.api.resources.InstructorResource;
import es.upm.miw.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpResponse;
import es.upm.miw.http.HttpStatus;
public class Dispatcher {

    private InstructorResource instructorResource = new InstructorResource();

    private CourseResource courseResource = new CourseResource();
    
    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);   
    }

    public void doPost(HttpRequest request, HttpResponse response) {
      
        try {
            if (request.isEqualsPath(CourseResource.COURSE)) {

                String title = request.getBody().split(":")[0]; // body="themeId:vote"
                String credits = request.getBody().split(":")[1];
                courseResource.createCourse(title, Integer.valueOf(credits));

            } else if (request.isEqualsPath(InstructorResource.INSTRUCTOR)) {

                String firstName = request.getBody().split(":")[0];
                String lastName = request.getBody().split(":")[1];
                String hireDate = request.getBody().split(":")[2];
                String idCourse = request.getBody().split(":")[3];

                Calendar hdate = Calendar.getInstance();
                SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
                hdate.setTime(formattedDate.parse(hireDate));
                instructorResource.createInstructor(firstName, lastName, hdate, Integer.valueOf(idCourse));

            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doGet(HttpRequest request, HttpResponse response) {
       
        try {
            if (request.isEqualsPath(CourseResource.COURSE + CourseResource.ID)) {
                response.setBody(courseResource.readCourse(Integer.valueOf(request.paths()[1])).toString());

            } else if (request.isEqualsPath(InstructorResource.INSTRUCTOR + InstructorResource.ID)) {
                response.setBody(instructorResource.readInstructor(Integer.valueOf(request.paths()[1])).toString());

            } else if (request.isEqualsPath(CourseResource.COURSE + CourseResource.ID_INSTRUCTOR)) {
                response.setBody(courseResource.readInstructorCourse(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
        
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
        
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(InstructorResource.INSTRUCTOR + InstructorResource.ID)) {
                String body = instructorResource.deleteInstructor(Integer.valueOf(request.paths()[1])).toString();
                response.setBody(body);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
        
    }

    
    
}

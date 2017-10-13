package es.upm.miw.api;

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
      
        
    }

    public void doGet(HttpRequest request, HttpResponse response) {
       
        
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
        
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
        
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        responseError(response, new RequestInvalidException(request.getPath()));
        
    }

    
    
}

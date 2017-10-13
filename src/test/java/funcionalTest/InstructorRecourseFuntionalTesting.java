package funcionalTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.api.resources.CourseResource;
import es.upm.miw.api.resources.InstructorResource;
import es.upm.miw.http.HttpClientService;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpMethod;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpRequestBuilder;

public class InstructorRecourseFuntionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    private void createCourse() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("course1:5").build();
        new HttpClientService().httpRequest(request);
    }

    private void createInstructor() {
        createCourse();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InstructorResource.INSTRUCTOR)
                .body("Juan:Rodriguez:13/oct/2017:1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateInstructor() {
        this.createInstructor();
    }

    @Test(expected = HttpException.class)
    public void testCreateFirstNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InstructorResource.INSTRUCTOR).body("Juan:13/10/2017:1")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateStudentlastNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InstructorResource.INSTRUCTOR)
                .body("Rodriguez:13/oct/2017:1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateStudentHiredateEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InstructorResource.INSTRUCTOR).body("Juan:Rodriguez:1")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateInstructorIdSubjectNotFound() {
        createCourse();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(InstructorResource.INSTRUCTOR)
                .body("Juan:Rodriguez:13/oct/2017:2").build();
        new HttpClientService().httpRequest(request);
    }



}

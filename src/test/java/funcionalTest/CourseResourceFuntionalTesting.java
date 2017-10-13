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

public class CourseResourceFuntionalTesting {

    private HttpRequest request;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
        request = new HttpRequest();
    }

    private void createCourse() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("course1:5").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateCourse() {
        this.createCourse();

    }

    @Test(expected = HttpException.class)
    public void testCreateTitleCreditsEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateTitleEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body(":7").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateCreditsEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("course2:").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateExistCourse() {
        createCourse();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("course1:5").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadCourse() {
        this.createCourse();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CourseResource.COURSE).path(CourseResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"title\":course1,\"credits\":5}", new HttpClientService().httpRequest(request).getBody());

    }
    
   
 
    
    
    
    

}

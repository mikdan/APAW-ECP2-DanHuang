package funcionalTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.memory.DaoFactoryMemory;
import es.upm.miw.api.resources.CourseResource;
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
    public void testCreateCourseEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateExistCourse() {
        createCourse();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CourseResource.COURSE).body("course1:5").build();
        new HttpClientService().httpRequest(request);
    }
    
    
    


}

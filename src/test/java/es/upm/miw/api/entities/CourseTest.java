package es.upm.miw.api.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

    @Test
    public void testCourse() {
        assertNotNull(new Course("course1", 5).getCredits());
    }

}

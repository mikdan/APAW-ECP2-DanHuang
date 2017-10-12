package es.upm.miw.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.api.daos.CourseDao;
import es.upm.miw.api.entities.Course;

public class CourseDaoMemory extends GenericDaoMemory<Course> implements CourseDao {

    public CourseDaoMemory() {
        this.setMap(new HashMap<Integer, Course>());
    }

    @Override
    protected Integer getId(Course entity) {
        // TODO Auto-generated method stub
        return entity.getId();
    }

    @Override
    protected void setId(Course entity, Integer id) {
        // TODO Auto-generated method stub
        entity.setId(id);
        
    }

}
package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.CourseDao;
import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.InstructorDao;

public class DaoFactoryMemory extends DaoFactory{
    
    private InstructorDao instructorDao;
    
    private CourseDao courseDao;

    @Override
    public InstructorDao getInstructorDao() {
        // TODO Auto-generated method stub
        if(instructorDao == null){
            instructorDao = new InstructorDaoMemory();
        }
        return instructorDao;
    }

    @Override
    public CourseDao getCourseDao() {
        // TODO Auto-generated method stub
        if(courseDao == null){
            courseDao = new CourseDaoMemory();
        }
        
        return courseDao;
    }

}

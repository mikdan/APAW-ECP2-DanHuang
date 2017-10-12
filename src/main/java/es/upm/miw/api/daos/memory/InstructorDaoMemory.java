package es.upm.miw.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.api.daos.InstructorDao;
import es.upm.miw.api.entities.Instructor;

public class InstructorDaoMemory extends GenericDaoMemory<Instructor> implements InstructorDao{
    
    public InstructorDaoMemory(){
        this.setMap(new HashMap<Integer,Instructor>());
    }
    
    @Override
    protected Integer getId(Instructor entity) {
        // TODO Auto-generated method stub
        return entity.getId();
    }

    @Override
    protected void setId(Instructor entity, Integer id) {
        // TODO Auto-generated method stub
        entity.setId(id);
        
    }

}

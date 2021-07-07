package lesson3.dzspring.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public abstract class AbstractDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public <T> T getEntity(TypedQuery<T> query){
        final List<T> list = query.getResultList();
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}

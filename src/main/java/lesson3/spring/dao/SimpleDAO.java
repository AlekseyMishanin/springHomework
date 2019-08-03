package lesson3.spring.dao;

import lesson3.spring.model.Simple;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component ("simpleDAO")
@Transactional
public class SimpleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist (Simple simple) {entityManager.persist(simple);}

    public void merge (Simple simple) {entityManager.merge(simple);}

    public Simple find (String id) {return entityManager.find(Simple.class, id);}

    public void remove (String id) {entityManager.remove(find(id));}

    public List<Simple> findAll(){
        return entityManager.createQuery("from " + Simple.class.getSimpleName(), Simple.class).getResultList();
    }

    public void removeAll(){
        //entityManager.createQuery("delete from "+ Simple.class.getSimpleName()).executeUpdate();
        findAll().stream().forEach(a->entityManager.remove(a));
    }
}

package lesson3.dzspring.dao;

import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Project;
import lesson3.dzspring.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component("userDAO")
@Transactional
public class UserDAO extends AbstractDAO implements CommandDAO<User> {


    public void persist (User user) {entityManager.persist(user);}

    public void merge (User user) {entityManager.merge(user);}

    public User find (String id) {return entityManager.find(User.class, id);}

    public void remove (String id) {entityManager.remove(find(id));}

    public List<User> findAll(){
        return entityManager.createQuery("from " + User.class.getSimpleName(), User.class).getResultList();
    }

    public void removeAll(){
        findAll().stream().forEach(a->entityManager.remove(a));
    }

    public User getById(final String id){
        if(id.isEmpty()) return null;
        return getEntity(entityManager.createQuery("select a from User a where a.id = :id", User.class)
                .setParameter("id", id));
    }

    public List<User> getSortedByName(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> cq = cb.createQuery(User.class);
        final Root<User> root = cq.from(User.class);
        return entityManager.createQuery(cq.select(root).orderBy(cb.asc(root.get("login")))).getResultList();
    }
}

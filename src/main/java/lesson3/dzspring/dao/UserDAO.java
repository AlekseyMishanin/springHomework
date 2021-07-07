package lesson3.dzspring.dao;

import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component("userDAO")
@Transactional
public class UserDAO extends AbstractDAO implements CommandDAO<User> {


    public void persist (@NonNull final User user) {entityManager.persist(user);}

    public void merge (@NonNull final User user) {entityManager.merge(user);}

    @Transactional(readOnly = true)
    public User find (@NonNull final String id) {return entityManager.find(User.class, id);}

    public void remove (@NonNull final String id) {entityManager.remove(find(id));}

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return entityManager.createQuery("from " + User.class.getSimpleName(), User.class).getResultList();
    }

    public void removeAll(){
        findAll().stream().forEach(a->entityManager.remove(a));
    }

    @Transactional(readOnly = true)
    public User getById(@NonNull final  String id){
        if(id.isEmpty()) return null;
        return getEntity(entityManager.createQuery("select a from User a where a.id = :id", User.class)
                .setParameter("id", id));
    }

    @Transactional(readOnly = true)
    public List<User> getSortedByName(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> cq = cb.createQuery(User.class);
        final Root<User> root = cq.from(User.class);
        return entityManager.createQuery(cq.select(root).orderBy(cb.asc(root.get("login")))).getResultList();
    }
}

package lesson3.dzspring.dao;

import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Task;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;


@Component("taskDAO")
@Transactional
public class TaskDAO extends AbstractDAO implements CommandDAO<Task> {

    public Optional<Task> findSome(@NonNull final String id) {
        Optional<Task> result;
        if(id.isEmpty()) {
            result = Optional.empty();
        } else {
            result = Optional.of(entityManager.find(Task.class,id));
        }
        return result;
    }

    public void persist (@NonNull final Task task) {entityManager.persist(task);}

    public void merge (@NonNull final Task task) {entityManager.merge(task);}

    public Task find (@NonNull final String id) {return entityManager.find(Task.class, id);}

    public void remove (@NonNull final String id) {entityManager.remove(find(id));}

    public List<Task> findAll(){
        return entityManager.createQuery("from " + Task.class.getSimpleName(), Task.class).getResultList();
    }

    public Task getById(@NonNull final  String id){
        if(id.isEmpty()) return null;
        return getEntity(entityManager.createQuery("select a from Task a where a.id = :id", Task.class)
                .setParameter("id", id));
    }

    public List<Task> getSortedByName(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Task> cq = cb.createQuery(Task.class);
        final Root<Task> root = cq.from(Task.class);
        return entityManager.createQuery(cq.select(root).orderBy(cb.asc(root.get("title")))).getResultList();
    }


    public void removeAll(){
        findAll().stream().forEach(a->entityManager.remove(a));
    }
}

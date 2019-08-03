package lesson3.dzspring.dao;

import lesson3.dzspring.interfaces.CommandDAO;
import lesson3.dzspring.model.Project;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Component("projectDAO")
@Transactional
public class ProjectDAO extends AbstractDAO implements CommandDAO<Project> {


    public void persist (@NonNull final Project project) {entityManager.persist(project);}

    public void merge (@NonNull final Project project) {entityManager.merge(project);}

    public Project find (@NonNull final String id) {return entityManager.find(Project.class, id);}

    public void remove (@NonNull final String id) {entityManager.remove(find(id));}

    public List<Project> findAll(){
        return entityManager.createQuery("from " + Project.class.getSimpleName(), Project.class).getResultList();
    }

    public void removeAll(){
        findAll().stream().forEach(a->entityManager.remove(a));
    }

    public Project getById(@NonNull final  String id){
        if(id.isEmpty()) return null;
        return getEntity(entityManager.createQuery("select a from Project a where a.id = :id", Project.class)
                .setParameter("id", id));
    }

    public List<Project> getSortedByName(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Project> cq = cb.createQuery(Project.class);
        final Root<Project> root = cq.from(Project.class);
        return entityManager.createQuery(cq.select(root).orderBy(cb.asc(root.get("name")))).getResultList();
    }
}

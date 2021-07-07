package lesson3.dzspring.model;

import lesson3.dzspring.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "dz_project")
public class Project {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Task> tasks;

    @Column(name = "archived")
    @Enumerated
    private Status status;

    public Project() {
    }
}

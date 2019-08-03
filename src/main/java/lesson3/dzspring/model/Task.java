package lesson3.dzspring.model;

import lesson3.dzspring.enums.Status;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dz_task")
public class Task {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String name;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Project project;

    @Column(name = "archived")
    @Enumerated
    private Status status;

    public Task() {
    }
}

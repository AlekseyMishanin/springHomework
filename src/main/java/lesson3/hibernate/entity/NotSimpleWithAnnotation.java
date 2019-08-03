package lesson3.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "exampleTable")
public class NotSimpleWithAnnotation {

    @Id
    private String id;

    @Column(name = "title", unique = true)
    private String name;

    @Column(columnDefinition = "VARCHAR(200)")
    private String description;

    @Column (length = 100)
    private String comment;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateCreate")
    private Date date;

    @Column(name = "archived")
    private boolean bool = false;
}

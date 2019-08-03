package lesson3.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class NotSimple {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Date dateCreate;
    private boolean isAuthor = false;
    private int spore;
}

package lesson3.dzspring.model;

import lesson3.dzspring.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dz_user")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @Column(name = "archived")
    @Enumerated
    private Status status;

    public User() {
    }
}

package lesson3.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Simple {

    @Id
    private String id;

    private String name;

    private String description;
}

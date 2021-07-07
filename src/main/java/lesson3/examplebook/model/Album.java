package lesson3.examplebook.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "VERSION")
    @Version
    private int version;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;

    @Override
    public String toString() {
        return "Album - id: " + id + ", title: "
                + title + ", release date"
                + releaseDate;
    }
}

package lesson3.examplebook.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name = "Singer.findAllWithAlbum",
                    query = "select distinct s from Singer s "
                            + " left join fetch s.albums a "
                            + " left join fetch s.instruments i"),
        @NamedQuery(name = "Singer.findById",
                    query = "select distinct s from Singer s " +
                            "left join fetch s.albums a " +
                            "left join fetch s.instruments i" +
                            " where s.id = :id" )
})
public class Singer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Version
    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "singer",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "singer_instrument",
                joinColumns = @JoinColumn(name = "SINGER_ID"),
                inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();

    public boolean addAlbum(Album album){
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void rmoveAlbum(Album album){
        getAlbums().remove(album);
    }

    @Override
    public String toString() {
        return "Singer - id: " + id + ", first name: "
                + first_name + ", last name: "
                + last_name + ", birthday: "
                + birthDate;
    }
}

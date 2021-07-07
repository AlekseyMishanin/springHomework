package lesson3.examplebook.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

    @Id
    @Column(name = "INSTRUMENT_ID")
    private String instrumentId;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
                joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
                inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    private Set<Singer> singers = new HashSet<>();

    @Override
    public String toString() {
        return "Instrument: " + getInstrumentId();
    }
}

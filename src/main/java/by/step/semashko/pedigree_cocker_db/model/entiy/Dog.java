package by.step.semashko.pedigree_cocker_db.model.entiy;

import by.step.semashko.pedigree_cocker_db.model.enums.Colour;
import by.step.semashko.pedigree_cocker_db.model.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class Dog extends NamedEntity {
    @Column(name = "number")
    private String number;
    @ManyToOne(cascade = CascadeType.ALL)
    private Dog mother;
    @ManyToOne(cascade = CascadeType.ALL)
    private Dog father;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_birth")
    private Date dateBirth;
    @Column(name = "land_birth")
    private String landBirth;
    @Column(name = "land_standing")
    private String landStanding;
    @Enumerated(EnumType.STRING)
    @Column(name = "colour")
    private Colour colour;
    @Column(name="titles")
    private String titles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(columnDefinition = "photo")
    private String photo;

    @Transient
    public String getPhotoImagePath() {
        if (photo == null || id == null) return null;

        return "/dog-photos/" + id + "/" + photo;
    }

    @Override
    public String toString() {
        return super.name.toUpperCase();

    }
}

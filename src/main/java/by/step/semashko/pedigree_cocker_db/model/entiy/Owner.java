package by.step.semashko.pedigree_cocker_db.model.entiy;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dog_id",
        discriminatorType = DiscriminatorType.INTEGER)
public class Owner extends NamedEntity {
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "owner")
    private Set<Dog>dogs;
}

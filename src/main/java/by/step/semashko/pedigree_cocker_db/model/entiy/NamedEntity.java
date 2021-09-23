package by.step.semashko.pedigree_cocker_db.model.entiy;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)

@MappedSuperclass
@Data
public abstract class NamedEntity extends BaseEntity {

    @Column(name = "name")
    protected String name;
}

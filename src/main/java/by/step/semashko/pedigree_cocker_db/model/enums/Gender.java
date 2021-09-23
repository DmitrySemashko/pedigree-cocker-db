package by.step.semashko.pedigree_cocker_db.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    @Getter
    @Setter
    private String gender;

}

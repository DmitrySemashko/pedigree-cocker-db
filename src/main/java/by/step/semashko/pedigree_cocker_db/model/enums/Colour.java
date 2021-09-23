package by.step.semashko.pedigree_cocker_db.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Colour {
    black("black",1),
    red("red",1),
    golden("golden",1),
    liver("liver",1),
    black_and_tan("black_and_tan",1),
    liver_and_tan("liver_and_tan",1),
    black_and_white("black_and_white",1),
    orange_and_white("orange_and_white",2),
    liver_and_white("liver_and_white",2),
    lemon_and_white("lemon_and_white",2),
    black_white_and_tan("black_white_and_tan",2),
    liver_white_and_tan("liver_white_and_tan",2),
    blue_roan("blue_roan",2),
    orange_roan("orange_roan",2),
    lemon_roan("lemon_roan",2),
    liver_roan("liver_roan",3),
    blue_roan_and_tan("blue_roan_and_tan",3),
    liver_roan_and_tan("liver_roan_and_tan",3);

    @Getter
    @Setter
    private String colour;
    @Getter
    @Setter
    private int group;
}

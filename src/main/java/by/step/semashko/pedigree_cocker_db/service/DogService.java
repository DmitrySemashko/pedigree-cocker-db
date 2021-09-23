package by.step.semashko.pedigree_cocker_db.service;

import by.step.semashko.pedigree_cocker_db.model.entiy.Dog;
import by.step.semashko.pedigree_cocker_db.model.enums.Colour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DogService {

    boolean add(Dog dog);

    List<Dog> findAll();

    List<Dog> findByName(String name);

    Dog findByNumber(String number);

    Page<Dog> findAllPage(Pageable pageable);

    List<Colour> getColour();

    Optional<Dog> findById(Long id);

    Dog update(Dog dog);
}

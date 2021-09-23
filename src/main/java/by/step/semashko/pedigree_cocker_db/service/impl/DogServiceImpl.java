package by.step.semashko.pedigree_cocker_db.service.impl;

import by.step.semashko.pedigree_cocker_db.model.entiy.Dog;
import by.step.semashko.pedigree_cocker_db.model.enums.Colour;
import by.step.semashko.pedigree_cocker_db.repository.DogRepository;
import by.step.semashko.pedigree_cocker_db.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {


    private DogRepository repository;



    @Override
    public boolean add(Dog dog) {
        List<Dog> dogs = repository.findByName(dog.getName());
        Dog dog1 = dogs.stream().filter(Objects::nonNull).findAny().orElse(null);
        if (dog1 != null) {
            return false;
        }
        repository.save(dog);
        return true;

    }


    @Override
    public Dog update(Dog dog) {
        return null;
    }

    @Override
    public List<Dog> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Dog> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Dog findByNumber(String number) {
        return repository.findByNumber(number);
    }

    @Override
    public List<Colour> getColour() {
        return Arrays.asList(Colour.values());
    }

    @Override
    public Optional<Dog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Dog> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Autowired
    public void setRepository(DogRepository repository) {
        this.repository = repository;
    }

}

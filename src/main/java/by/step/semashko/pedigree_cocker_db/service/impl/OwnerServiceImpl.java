package by.step.semashko.pedigree_cocker_db.service.impl;

import by.step.semashko.pedigree_cocker_db.model.entiy.Owner;
import by.step.semashko.pedigree_cocker_db.repository.OwnerRepository;
import by.step.semashko.pedigree_cocker_db.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository repository;
    @Override
    public boolean add(Owner owner) {
        List<Owner> dogs = repository.findByName(owner.getName());
        Owner owner1 = dogs.stream().filter(Objects::nonNull).findAny().orElse(null);
        if (owner1 != null) {
            return false;
        }
        repository.save(owner);
        return true;
    }

    @Override
    public List<Owner> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Owner> findAll() {
        return repository.findAll();
    }
}

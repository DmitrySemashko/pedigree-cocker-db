package by.step.semashko.pedigree_cocker_db.service;

import by.step.semashko.pedigree_cocker_db.model.entiy.Owner;

import java.util.List;

public interface OwnerService {

    boolean add(Owner owner);
    List<Owner> findByName(String name);
    List<Owner> findAll();

}

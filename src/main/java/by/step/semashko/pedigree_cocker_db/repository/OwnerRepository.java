package by.step.semashko.pedigree_cocker_db.repository;

import by.step.semashko.pedigree_cocker_db.model.entiy.Dog;
import by.step.semashko.pedigree_cocker_db.model.entiy.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    List<Owner> findByName(String name);

}

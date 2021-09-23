package by.step.semashko.pedigree_cocker_db.repository;

import by.step.semashko.pedigree_cocker_db.model.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    User findByActivationCode(String code);
}

package by.step.semashko.pedigree_cocker_db.service.impl;

import by.step.semashko.pedigree_cocker_db.model.enums.Role;
import by.step.semashko.pedigree_cocker_db.model.entiy.User;
import by.step.semashko.pedigree_cocker_db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;
    private MailSender mailSender;

    public boolean save(User user) {
        User userDb = repository.findByName(user.getUsername());
        if (userDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        sendMessage(user);
        return true;
    }

    private void sendMessage(User user) {
        if (!StringUtils.hasLength(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Sweater. Please, visit next link:http://localhost:8080/activate/%s",
                    user.getName(),
                    user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        User user = repository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);

        repository.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        repository.save(user);
    }
}

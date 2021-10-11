package regformspring.regformspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import regformspring.regformspring.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

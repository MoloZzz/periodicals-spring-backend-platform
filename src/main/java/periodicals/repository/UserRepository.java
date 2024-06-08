package periodicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodicals.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

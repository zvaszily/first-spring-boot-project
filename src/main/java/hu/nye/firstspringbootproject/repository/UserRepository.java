package hu.nye.firstspringbootproject.repository;

import hu.nye.firstspringbootproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();

    User findByEmail(String email);
}

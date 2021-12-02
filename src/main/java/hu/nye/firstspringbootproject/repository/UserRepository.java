package hu.nye.firstspringbootproject.repository;

import hu.nye.firstspringbootproject.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
}

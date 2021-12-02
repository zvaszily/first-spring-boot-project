package hu.nye.firstspringbootproject.repository;

import hu.nye.firstspringbootproject.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
    List<Users> findAll();
}

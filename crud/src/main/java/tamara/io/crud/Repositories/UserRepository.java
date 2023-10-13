package tamara.io.crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tamara.io.crud.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}

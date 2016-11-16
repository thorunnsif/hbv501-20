package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.persistence.entities.UserData;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by EiríkurAtli on 4.11.2016.
 */

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    UserData save(UserData userData);

    void delete(UserData userData);

    List<UserData> findAll();

    List<UserData> findByUsername(String username);

    // Instead of the method findAllReverseOrder() in PostitNoteService.java,
    // We could have used this method by adding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    List<UserData> findAllByOrderByIdDesc();

    UserData findOne(Long id);

    //boolean exists(String username, String password);

    @Query(value = "SELECT count(p.username) FROM UserData p WHERE p.username = :username AND p.password = :password")
    int isValidUser(@Param("username") String username, @Param("password") String password) throws SQLException;
}

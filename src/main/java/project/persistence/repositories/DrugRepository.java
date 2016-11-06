package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Drug;

import java.util.List;

/**
 * Created by thorunn on 06/11/16.
 */
public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByName(String name);

//    List<Drug> findByType(String type);

    List<Drug> findByActiveIngr(String activeIngr);

}

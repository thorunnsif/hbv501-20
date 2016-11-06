package project.service;

import project.persistence.entities.Drug;

import java.util.List;

/**
 * Created by thorunn on 05/11/16.
 */
public interface DrugService {

    List<Drug> findAllReverseOrder();

    Drug save(Drug drug);
}

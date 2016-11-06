package project.service;

import project.persistence.entities.Drug;

import java.util.List;

/**
 * Created by thorunn on 05/11/16.
 */
public interface DrugService {

    /**
     * Save a {@link Drug}
     * @param drug {@link Drug} to be saved
     * @return {@link Drug} that was saved
     */
    Drug save(Drug drug);

    /**
     * Delete {@link Drug}
     * @param drug {@link Drug} to be deleted
     */
    void delete(Drug drug);

    /**
     * Get all {@link Drug}s
     * @return A list of {@link Drug}s
     */
    List<Drug> findAll();

    /**
     * Get all {@link Drug}s in a reverse order
     * @return A reverse list of {@link Drug}s
     */
    List<Drug> findAllReverseOrder();

    /**
     * Find all {@link Drug}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Drug}s with the {@link String name} passed
     */
    List<Drug> findByName(String name);

    /**
     * Find all {@link Drug}s with {@link String type}
     * @param type {@link String}
     * @return All {@link Drug}s with the {@link String type} passed
     */
    List<Drug> findByType(String type);

    /**
     * Find all {@link Drug}s with {@link String activeIngr}
     * @param activeIngr {@link String}
     * @return All {@link Drug}s with the {@link String activeIngr} passed
     */
    List<Drug> findByActiveIngr(String activeIngr);
}

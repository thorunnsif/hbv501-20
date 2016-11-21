package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Drug;
import project.persistence.repositories.DrugRepository;
import project.service.DrugService;

import java.util.Collections;
import java.util.List;

/**
 * Created by thorunn on 06/11/16.
 */
@Service
public class DrugServiceImplementation implements DrugService{

    // Instance Variables
    DrugRepository repository;

    // Dependency Injection
    @Autowired
    public DrugServiceImplementation(DrugRepository repository) {
        this.repository = repository;
    }

    @Override
    public Drug save(Drug drug) {
        return repository.save(drug);
    }

    @Override
    public void delete(Drug drug) {
        repository.delete(drug);
    }

    @Override
    public List<Drug> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Drug> findAllReverseOrder() {
        List<Drug> drugs = findAll();
        Collections.reverse(drugs);
        return drugs;
    }

    @Override
    public List<Drug> findByName(String name) {
        System.out.println(name);
        return repository.findByName(name);
    }

/*
    @Override
    public List<Drug> findByType(String type) {
        return repository.findByType(type);
    }
*/
    @Override
    public List<Drug> findByActiveIngr(String activeIngr) {
        return repository.findByActiveIngr(activeIngr);
    }
}

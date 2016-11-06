package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.UserData;
import project.persistence.repositories.UserDataRepository;
import project.service.UserDataService;

import java.util.Collections;
import java.util.List;

/**
 * Created by EiríkurAtli on 4.11.2016.
 */
@Service
public class UserDataServiceImplementation implements UserDataService {


    // Instance Variables
    UserDataRepository repository;

    // Dependency Injection
    @Autowired
    public UserDataServiceImplementation(UserDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserData save(UserData userData) {
        return repository.save(userData);
    }

    @Override
    public void delete(UserData userData) {
        repository.delete(userData);
    }

    @Override
    public List<UserData> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UserData> findAllReverseOrder() {
        // Get all the Postit notes
        List<UserData> userDatas = repository.findAll();

        // Reverse the list
        Collections.reverse(userDatas);

        return userDatas;
    }

    @Override
    public UserData findOne(Long id) {
        return repository.findOne(id);
    }


    @Override
    public List<UserData> findByUsername(String username) {return repository.findByUsername(username);
    }

}
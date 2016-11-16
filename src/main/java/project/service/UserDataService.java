package project.service;

import project.persistence.entities.UserData;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by EiríkurAtli on 4.11.2016.
 */

public interface UserDataService {

    /**
     * Save a {@link UserData}
     * @param userData {@link UserData} to be saved
     * @return {@link UserData} that was saved
     */
    UserData save(UserData userData);

    /**
     * Delete {@link UserData}
     * @param userData {@link UserData} to be deleted
     */
    void delete(UserData userData);

    /**
     * Get all {@link UserData}s
     * @return A list of {@link UserData}s
     */
    List<UserData> findAll();

    /**
     * Get all {@link UserData}s in a reverse order
     * @return A reversed list of {@link UserData}s
     */
    List<UserData> findAllReverseOrder();

    /**
     * Find a {@link UserData} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link UserData} with {@link Long id}
     */
    UserData findOne(Long id);

    /**
     * Find all {@link UserData}s with {@link String username}
     * @param username {@link String}
     * @return All {@link UserData}s with the {@link String username} passed
     */
    List<UserData> findByUsername(String username);

    /**
     * Check if {@link String username} and {@link String password} exist and fit
     * @param username {@link String}
     * @param password (@link Sting)
     * @return true if check on {@link String username} and {@link String password} passed
     */
    int isValidUser(String username, String password) throws SQLException;


}

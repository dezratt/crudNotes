package org.launchcode.crudnotes.data;

import org.launchcode.crudnotes.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

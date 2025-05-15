package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    public abstract ArrayList<Users> findByUserName(String userName);

    public abstract ArrayList<Users> findByUserEmail(String userEmail);

}

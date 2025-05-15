package com.urbanpass.urbanpass.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Repository.UsersRepository;

@Service
public class UsersServices{

    @Autowired // conecta la clase UsersRepositorios
    UsersRepository usersRepositorios;

    public ArrayList<Users> obtenerUsuarios() {
        return (ArrayList<Users>) usersRepositorios.findAll();
    }

    public Users guardarUsuario(Users users) {
        return usersRepositorios.save(users);
    }

     public Users obtenerPorId(Long id) {
        return usersRepositorios.findById(id).orElse(null);
    }

    public ArrayList<Users> obtenerPorNombre(String userName) {
        return usersRepositorios.findByUserName(userName);
    }

    public ArrayList<Users> obtenerPorEmail(String userEmail) {
        return usersRepositorios.findByUserEmail(userEmail);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usersRepositorios.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
   
}


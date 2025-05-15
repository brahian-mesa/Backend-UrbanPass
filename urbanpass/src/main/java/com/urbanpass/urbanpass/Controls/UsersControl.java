package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Services.UsersServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/users")
public class UsersControl {

    @Autowired
    UsersServices usersServicios;
    
    @GetMapping()
    public ArrayList<Users> obtenerUsuarios(){
        return usersServicios.obtenerUsuarios();
    }

    @PostMapping()
    public Users guardarUsuario(@RequestBody Users users){
        return usersServicios.guardarUsuario(users);
    }

    @GetMapping(path = "/id/{id}")
    public Users obtenerusuarioporId(@PathVariable("id") Long id){
        return usersServicios.obtenerPorId(id);
    }
    @GetMapping(path = "/name/{userName}")
    public ArrayList<Users> obtenerusuarioporNombre(@RequestParam("userName") String userName){
        return usersServicios.obtenerPorNombre(userName);
    }
    @GetMapping(path = "/email/{userEmail}")
    public ArrayList<Users> obtenerusuarioporEmail(@RequestParam("userEmail") String userEmail){
        return usersServicios.obtenerPorEmail(userEmail);
    }
    
}

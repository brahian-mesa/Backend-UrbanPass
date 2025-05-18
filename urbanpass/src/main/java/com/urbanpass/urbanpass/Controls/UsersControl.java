package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Services.UsersServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("api/users")
public class UsersControl {

    @Autowired
    UsersServices usersServicios;

    @GetMapping()
    public ArrayList<Users> obtenerUsuarios() {
        return usersServicios.obtenerUsuarios();
    }

    @PostMapping()
    public Users guardarUsuario(@RequestBody Users usuario) {
        return this.usersServicios.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Users obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usersServicios.obtenerPorId(id);
    }

    @GetMapping(path = "/name/{userName}")
    public ArrayList<Users> obtenerusuarioporNombre(@PathVariable("userName") String userName) {
        return usersServicios.obtenerPorNombre(userName);
    }

    @GetMapping(path = "/email/{userEmail}")
    public ArrayList<Users> obtenerusuarioporEmail(@PathVariable("userEmail") String userEmail) {
        return usersServicios.obtenerPorEmail(userEmail);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usersServicios.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
}

package com.urbanpass.urbanpass.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.sql.Date;
import jakarta.transaction.Transactional;
import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Repository.UsersRepository;
import com.urbanpass.urbanpass.Repository.CardsRepositorys;
import com.urbanpass.urbanpass.Repository.BillsRepositorys;
import com.urbanpass.urbanpass.Repository.RecordsRepositorys;

@Service
public class UsersServices {

    @Autowired // conecta la clase UsersRepositorios
    UsersRepository usersRepositorios;

    @Autowired
    CardsRepositorys cardsRepository;

    @Autowired
    BillsRepositorys billsRepository;

    @Autowired
    RecordsRepositorys recordsRepository;

    public ArrayList<Users> obtenerUsuarios() {
        return (ArrayList<Users>) usersRepositorios.findAll();
    }

    @Transactional
    public Users guardarUsuario(Users users) {
        // Primero guardamos el usuario
        Users savedUser = usersRepositorios.save(users);

        // Creamos una nueva tarjeta para el usuario
        Cards newCard = new Cards();
        newCard.setUser(savedUser);
        newCard.setCardBalance(0.0); // Saldo inicial
        newCard.setCardNumber(generateCardNumber(savedUser.getUserId())); // Generar número de tarjeta
        newCard.setCardCvc(generateCVC()); // Generar CVC
        newCard.setCardExpedition(new Date(System.currentTimeMillis())); // Fecha actual

        // Guardamos la tarjeta
        cardsRepository.save(newCard);

        return savedUser;
    }

    private String generateCardNumber(Long userId) {
        // Formato: "UP" + userId rellenado con ceros + 10 dígitos aleatorios
        String userIdStr = String.format("%06d", userId);
        String randomPart = String.format("%010d", (long) (Math.random() * 10000000000L));
        return "UP" + userIdStr + randomPart;
    }

    private int generateCVC() {
        // Genera un número aleatorio de 3 dígitos
        return 100 + (int) (Math.random() * 900);
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

    @Transactional
    public void eliminarTodosLosUsuarios() {
        // Primero eliminamos todos los registros de uso de tarjetas
        recordsRepository.deleteAll();

        // Luego eliminamos todas las tarjetas
        cardsRepository.deleteAll();

        // Después eliminamos todas las facturas
        billsRepository.deleteAll();

        // Finalmente eliminamos todos los usuarios
        usersRepositorios.deleteAll();
    }
}

package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Cards;

@Repository
public interface CardsRepositorys extends CrudRepository<Cards, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar usuarios por nombre o correo electrónico
    ArrayList<Cards> findByCardId(Long cardId);

    ArrayList<Cards> findByUser_UserId(Long userId);

    ArrayList<Cards> findByCardNumber(String cardNumber);
}
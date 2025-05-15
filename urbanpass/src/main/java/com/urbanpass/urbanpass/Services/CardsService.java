package com.urbanpass.urbanpass.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Repository.CardsRepositorys;

@Service
public class CardsService {

    @Autowired
    CardsRepositorys cardsRepository;

    // Obtener todas las tarjetas
    public ArrayList<Cards> obtenerTodasLasCards() {
        return (ArrayList<Cards>) cardsRepository.findAll();
    }

    // Guardar una tarjeta
    public Cards guardarCard(Cards card) {
        return cardsRepository.save(card);
    }

    // Obtener una tarjeta por ID (clave primaria)
    public Cards obtenerPorId(Long id) {
        Optional<Cards> optionalCard = cardsRepository.findById(id);
        return optionalCard.orElse(null);
    }

    // Obtener tarjetas por el campo cardId
    public ArrayList<Cards> obtenerPorCardId(Long cardId) {
        return cardsRepository.findByCardId(cardId);
    }

    // Eliminar una tarjeta por ID
    public boolean eliminarCard(Long id) {
        try {
            cardsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

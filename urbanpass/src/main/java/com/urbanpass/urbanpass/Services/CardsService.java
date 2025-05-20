package com.urbanpass.urbanpass.Services;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Models.Records;
import com.urbanpass.urbanpass.Repository.CardsRepositorys;

@Service
public class CardsService {

    @Autowired
    CardsRepositorys cardsRepository;

    @Autowired
    RecordsServices recordsService;

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

    // Obtener tarjetas por número de tarjeta
    public ArrayList<Cards> obtenerPorNumeroTarjeta(String cardNumber) {
        return cardsRepository.findByCardNumber(cardNumber);
    }

    // Obtener tarjetas por usuario
    public ArrayList<Cards> obtenerPorUsuario(Long userId) {
        return cardsRepository.findByUser_UserId(userId);
    }

    // Actualizar saldo de una tarjeta
    public Cards actualizarSaldo(Long id, double nuevoSaldo) {
        Optional<Cards> optionalCard = cardsRepository.findById(id);
        if (optionalCard.isPresent()) {
            Cards card = optionalCard.get();
            card.setCardBalance(nuevoSaldo);
            return cardsRepository.save(card);
        }
        return null;
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

    // Actualizar saldo de una tarjeta por número
    @Transactional
    public Cards actualizarSaldoPorNumero(String cardNumber, double nuevoSaldo) {
        ArrayList<Cards> cards = cardsRepository.findByCardNumber(cardNumber);
        if (!cards.isEmpty()) {
            Cards card = cards.get(0);
            // Asegurarse de que el nuevo saldo sea positivo
            if (nuevoSaldo >= 0) {
                double saldoAnterior = card.getCardBalance();
                double montoRecarga = nuevoSaldo - saldoAnterior;

                card.setCardBalance(nuevoSaldo);
                Cards updatedCard = cardsRepository.save(card);

                // Crear registro de la recarga
                Records record = new Records();
                record.setCard(updatedCard);
                record.setRecordDate(new Date(System.currentTimeMillis()));
                record.setOperationType("RECHARGE");
                record.setAmount(montoRecarga);
                // El fence es null porque es una recarga
                record.setFence(null);
                recordsService.guardarRecords(record);

                return updatedCard;
            }
        }
        return null;
    }
}

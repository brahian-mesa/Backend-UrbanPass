package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Services.CardsService;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("api/cards")
public class CardsControl {

    @Autowired
    CardsService cardsService;

    @GetMapping()
    public ArrayList<Cards> obtenerCards() {
        return cardsService.obtenerTodasLasCards();
    }

    @PostMapping()
    public ResponseEntity<Cards> guardarCard(@RequestBody Cards card) {
        try {
            // Validar que todos los campos requeridos estén presentes
            if (card.getCardNumber() == null || card.getCardNumber().isEmpty() ||
                    card.getCardCvc() <= 0 ||
                    card.getCardExpedition() == null ||
                    card.getUser() == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            Cards savedCard = cardsService.guardarCard(card);
            return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cards> obtenerCardPorId(@PathVariable("id") Long id) {
        Cards card = cardsService.obtenerPorId(id);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/cardId/{cardId}")
    public ResponseEntity<ArrayList<Cards>> obtenerCardPorCardId(@PathVariable("cardId") Long cardId) {
        ArrayList<Cards> cards = cardsService.obtenerPorCardId(cardId);
        if (!cards.isEmpty()) {
            return new ResponseEntity<>(cards, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/number/{cardNumber}")
    public ResponseEntity<ArrayList<Cards>> obtenerCardPorNumero(@PathVariable("cardNumber") String cardNumber) {
        ArrayList<Cards> cards = cardsService.obtenerPorNumeroTarjeta(cardNumber);
        if (!cards.isEmpty()) {
            return new ResponseEntity<>(cards, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<ArrayList<Cards>> obtenerCardsPorUsuario(@PathVariable("userId") Long userId) {
        ArrayList<Cards> cards = cardsService.obtenerPorUsuario(userId);
        if (!cards.isEmpty()) {
            return new ResponseEntity<>(cards, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{id}/balance")
    public ResponseEntity<Cards> actualizarSaldo(@PathVariable("id") Long id, @RequestBody double nuevoSaldo) {
        try {
            Cards updatedCard = cardsService.actualizarSaldo(id, nuevoSaldo);
            if (updatedCard != null) {
                return new ResponseEntity<>(updatedCard, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> eliminarCard(@PathVariable("id") Long id) {
        boolean wasDeleted = cardsService.eliminarCard(id);
        if (wasDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

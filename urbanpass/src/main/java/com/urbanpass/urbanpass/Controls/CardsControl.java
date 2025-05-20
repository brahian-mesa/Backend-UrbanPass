package com.urbanpass.urbanpass.Controls;

import java.sql.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Services.CardsService;
import com.urbanpass.urbanpass.Services.UsersServices;
import com.urbanpass.urbanpass.DTO.CardResponseDTO;
import com.urbanpass.urbanpass.DTO.CreateCardDTO;
import com.urbanpass.urbanpass.DTO.SaldoDTO;

@RestController
@RequestMapping("api/cards")
public class CardsControl {

    @Autowired
    CardsService cardsService;

    @Autowired
    UsersServices usersService;

    @GetMapping()
    public ResponseEntity<ArrayList<CardResponseDTO>> obtenerCards() {
        ArrayList<Cards> cards = cardsService.obtenerTodasLasCards();
        ArrayList<CardResponseDTO> dtos = cards.stream()
                .map(CardResponseDTO::fromCard)
                .collect(Collectors.toCollection(ArrayList::new));
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CardResponseDTO> guardarCard(@RequestBody CreateCardDTO createCardDTO) {
        try {
            // Validar que todos los campos requeridos estén presentes
            if (createCardDTO.getCardNumber() == null || createCardDTO.getCardNumber().isEmpty() ||
                    createCardDTO.getCardCvc() <= 0 ||
                    createCardDTO.getCardExpedition() == null ||
                    createCardDTO.getUserId() == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // Obtener el usuario
            Users user = usersService.obtenerPorId(createCardDTO.getUserId());
            if (user == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // Crear y configurar la nueva tarjeta
            Cards card = new Cards();
            card.setCardBalance(createCardDTO.getCardBalance());
            card.setCardNumber(createCardDTO.getCardNumber());
            card.setCardCvc(createCardDTO.getCardCvc());
            card.setCardExpedition(createCardDTO.getCardExpedition());
            card.setUser(user);

            Cards savedCard = cardsService.guardarCard(card);
            return new ResponseEntity<>(CardResponseDTO.fromCard(savedCard), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CardResponseDTO> obtenerCardPorId(@PathVariable("id") Long id) {
        Cards card = cardsService.obtenerPorId(id);
        if (card != null) {
            return new ResponseEntity<>(CardResponseDTO.fromCard(card), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/cardId/{cardId}")
    public ResponseEntity<ArrayList<CardResponseDTO>> obtenerCardPorCardId(@PathVariable("cardId") Long cardId) {
        ArrayList<Cards> cards = cardsService.obtenerPorCardId(cardId);
        if (!cards.isEmpty()) {
            ArrayList<CardResponseDTO> dtos = cards.stream()
                    .map(CardResponseDTO::fromCard)
                    .collect(Collectors.toCollection(ArrayList::new));
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/number/{cardNumber}")
    public ResponseEntity<ArrayList<CardResponseDTO>> obtenerCardPorNumero(
            @PathVariable("cardNumber") String cardNumber) {
        ArrayList<Cards> cards = cardsService.obtenerPorNumeroTarjeta(cardNumber);
        if (!cards.isEmpty()) {
            ArrayList<CardResponseDTO> dtos = cards.stream()
                    .map(CardResponseDTO::fromCard)
                    .collect(Collectors.toCollection(ArrayList::new));
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<ArrayList<CardResponseDTO>> obtenerCardsPorUsuario(@PathVariable("userId") Long userId) {
        ArrayList<Cards> cards = cardsService.obtenerPorUsuario(userId);
        if (!cards.isEmpty()) {
            ArrayList<CardResponseDTO> dtos = cards.stream()
                    .map(CardResponseDTO::fromCard)
                    .collect(Collectors.toCollection(ArrayList::new));
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{id}/balance")
    public ResponseEntity<CardResponseDTO> actualizarSaldo(@PathVariable("id") Long id,
            @RequestBody double nuevoSaldo) {
        try {
            Cards updatedCard = cardsService.actualizarSaldo(id, nuevoSaldo);
            if (updatedCard != null) {
                return new ResponseEntity<>(CardResponseDTO.fromCard(updatedCard), HttpStatus.OK);
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

    @PutMapping(path = "/number/{cardNumber}/balance")
    public ResponseEntity<CardResponseDTO> actualizarSaldoPorNumero(
            @PathVariable("cardNumber") String cardNumber,
            @RequestBody SaldoDTO saldoDTO) {
        try {
            if (saldoDTO.getNuevoSaldo() < 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Cards updatedCard = cardsService.actualizarSaldoPorNumero(cardNumber, saldoDTO.getNuevoSaldo());
            if (updatedCard != null) {
                return new ResponseEntity<>(CardResponseDTO.fromCard(updatedCard), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

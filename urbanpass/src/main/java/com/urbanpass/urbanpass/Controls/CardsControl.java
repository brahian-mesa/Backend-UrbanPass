package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Services.CardsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/cards")
public class CardsControl {

    @Autowired
    CardsService cardsService;

    @GetMapping()
    public ArrayList<Cards> obtenerTodasLasCards() {
        return cardsService.obtenerTodasLasCards();
    }

    @PostMapping()
    public Cards guardarCard(@RequestBody Cards card) {
        return cardsService.guardarCard(card);
    }

    @GetMapping(path = "/id/{id}")
    public Cards obtenerCardPorId(@PathVariable("id") Long id) {
        return cardsService.obtenerPorId(id);
    }

    @GetMapping(path = "/cardId")
    public ArrayList<Cards> obtenerCardPorCardId(@RequestParam("cardId") Long cardId) {
        return cardsService.obtenerPorCardId(cardId);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarCard(@PathVariable("id") Long id) {
        return cardsService.eliminarCard(id);
    }
}

package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.urbanpass.urbanpass.Models.Records;
import com.urbanpass.urbanpass.Models.Cards;
import com.urbanpass.urbanpass.Services.RecordsServices;
import com.urbanpass.urbanpass.Services.CardsService;
import com.urbanpass.urbanpass.DTO.CardResponseDTO;
import com.urbanpass.urbanpass.DTO.SaldoDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/records")
public class RecordsControl {

    @Autowired
    RecordsServices recordsServicios;

    @Autowired
    CardsService cardsService;

    @GetMapping()
    public ArrayList<Records> obtenerRecords() {
        return recordsServicios.obtenerRecords();
    }

    @PostMapping()
    public Records guardarRecords(@RequestBody Records records) {
        return recordsServicios.guardarRecords(records);
    }

    @GetMapping(path = "/id/{id}")
    public Records obtenerRecordPorId(@PathVariable("id") Long id) {
        return recordsServicios.obtenerPorId(id);
    }

    @GetMapping(path = "/card/{cardNumber}")
    public ResponseEntity<ArrayList<Records>> obtenerRecordsPorTarjeta(@PathVariable("cardNumber") String cardNumber) {
        ArrayList<Records> records = recordsServicios.obtenerPorNumeroTarjeta(cardNumber);
        if (!records.isEmpty()) {
            return ResponseEntity.ok(records);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<ArrayList<Records>> obtenerRecordsPorUsuario(@PathVariable("userId") Long userId) {
        ArrayList<Records> records = recordsServicios.obtenerRecordsPorUsuario(userId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping(path = "/recordId")
    public ArrayList<Records> obtenerRecordPorRecordId(@RequestParam("recordId") Long recordId) {
        return recordsServicios.obtenerPorRecordId(recordId);
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
                // GUARDAR REGISTRO DE RECARGA
                Records recarga = new Records();
                recarga.setRecordDate(new java.sql.Date(System.currentTimeMillis()));
                recarga.setOperationType("RECHARGE");
                // Puedes guardar el monto recargado (nuevoSaldo - saldoAnterior) si lo
                // necesitas
                recarga.setAmount(saldoDTO.getNuevoSaldo());
                recarga.setCard(updatedCard);
                recarga.setFence(null); // No aplica para recarga
                recordsServicios.guardarRecords(recarga);

                return new ResponseEntity<>(CardResponseDTO.fromCard(updatedCard), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

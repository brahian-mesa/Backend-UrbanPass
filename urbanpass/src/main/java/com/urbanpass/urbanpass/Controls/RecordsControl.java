package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Records;
import com.urbanpass.urbanpass.Services.RecordsServices;

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

    @GetMapping(path = "/recordId")
    public ArrayList<Records> obtenerRecordPorRecordId(@RequestParam("recordId") Long recordId) {
        return recordsServicios.obtenerPorRecordId(recordId);
    }
}

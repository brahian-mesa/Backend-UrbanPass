package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Bills;
import com.urbanpass.urbanpass.Services.BillsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/bills")
public class BillsControl {

    @Autowired
    BillsService billsService;

    @GetMapping()
    public ArrayList<Bills> obtenerTodasLasBills() {
        return billsService.obtenerTodasLasBills();
    }

    @PostMapping()
    public Bills guardarBill(@RequestBody Bills bill) {
        return billsService.guardarBill(bill);
    }

    @GetMapping(path = "/id/{id}")
    public Bills obtenerBillPorId(@PathVariable("id") Long id) {
        return billsService.obtenerPorId(id);
    }

    @GetMapping(path = "/billId")
    public ArrayList<Bills> obtenerBillPorBillId(@RequestParam("billId") Long billId) {
        return billsService.obtenerPorBillId(billId);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarBill(@PathVariable("id") Long id) {
        return billsService.eliminarBill(id);
    }
}

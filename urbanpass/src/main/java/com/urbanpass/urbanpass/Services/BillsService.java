package com.urbanpass.urbanpass.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.urbanpass.urbanpass.Models.Bills;
import com.urbanpass.urbanpass.Repository.BillsRepositorys;

@Service
public class BillsService {

    @Autowired
    BillsRepositorys billsRepository;

    // Obtener todas las facturas
    public ArrayList<Bills> obtenerTodasLasBills() {
        return (ArrayList<Bills>) billsRepository.findAll();
    }

    // Guardar una factura
    public Bills guardarBill(Bills bill) {
        return billsRepository.save(bill);
    }

    // Obtener una factura por su ID (clave primaria)
    public Bills obtenerPorId(Long id) {
        Optional<Bills> optionalBill = billsRepository.findById(id);
        return optionalBill.orElse(null);
    }

    // Buscar facturas por billId (otro campo)
    public ArrayList<Bills> obtenerPorBillId(Long billId) {
        return billsRepository.findByBillId(billId);
    }

    // Eliminar una factura por ID
    public boolean eliminarBill(Long id) {
        try {
            billsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

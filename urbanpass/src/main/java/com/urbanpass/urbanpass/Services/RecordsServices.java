package com.urbanpass.urbanpass.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.urbanpass.urbanpass.Models.Records;
import com.urbanpass.urbanpass.Repository.RecordsRepositorys;

@Service
public class RecordsServices {

    @Autowired // conecta la clase UsersRepositorios
    RecordsRepositorys recordsRepsitorys;

    public ArrayList<Records> obtenerRecords() {
        return (ArrayList<Records>) recordsRepsitorys.findAll();
    }

    public Records guardarRecords(Records records) {
        return recordsRepsitorys.save(records);
    }

    public Records obtenerPorId(Long id) {
        return recordsRepsitorys.findById(id).orElse(null);
    }

    public ArrayList<Records> obtenerPorRecordId(Long recordId) {
        return recordsRepsitorys.findByRecordId(recordId);
    }

    public ArrayList<Records> obtenerPorNumeroTarjeta(String cardNumber) {
        return recordsRepsitorys.findByCard_CardNumber(cardNumber);
    }

    public ArrayList<Records> obtenerRecordsPorUsuario(Long userId) {
        return recordsRepsitorys.findByCard_User_UserId(userId);
    }

    public boolean eliminarRecords(Long id) {
        try {
            recordsRepsitorys.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}

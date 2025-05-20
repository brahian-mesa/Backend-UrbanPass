package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.urbanpass.urbanpass.Models.Records;

@Repository
public interface RecordsRepositorys extends CrudRepository<Records, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar usuarios por nombre o correo electrónico
    public abstract ArrayList<Records> findByRecordId(Long recordId);

    ArrayList<Records> findByCard_CardNumber(String cardNumber);

    ArrayList<Records> findByCard_User_UserId(Long userId);
}
package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.urbanpass.urbanpass.Models.Bills;

@Repository
public interface BillsRepositorys extends CrudRepository<Bills, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar usuarios por nombre o correo electrónico
    public abstract ArrayList<Bills> findByBillId(Long billId);
}
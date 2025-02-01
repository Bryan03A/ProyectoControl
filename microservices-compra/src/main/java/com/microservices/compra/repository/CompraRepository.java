package com.microservices.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.compra.model.Compra;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    // Método para eliminar múltiples compras
    @Modifying
    @Transactional
    @Query("DELETE FROM Compra c WHERE c.id IN :ids")
    void deleteAllByIdIn(@Param("ids") List<Long> ids);
}

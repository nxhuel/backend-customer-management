package com.app.gestion_empleados.persistence.repository;

import com.app.gestion_empleados.persistence.entity.ClientEntity;
import com.app.gestion_empleados.persistence.entity.ClientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientHistoryRepository extends JpaRepository<ClientHistory, Long>
{
    List<ClientHistory> findByClientId(Long clientId);

    @Modifying
    @Transactional
    @Query("DELETE FROM client_history ch WHERE ch.client.id = :clientId")
    void deleteByClientId(@Param("clientId") Long clientId);
}

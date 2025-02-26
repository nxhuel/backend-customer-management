package com.app.gestion_empleados.persistence.repository;

import com.app.gestion_empleados.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>
{
}

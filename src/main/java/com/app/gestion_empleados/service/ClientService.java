package com.app.gestion_empleados.service;

import com.app.gestion_empleados.persistence.entity.ClientEntity;

import java.util.List;

public interface ClientService
{
    ClientEntity saveClient(ClientEntity client, String detail);

    List<ClientEntity> getClients();

    ClientEntity getClient(Long id);

    ClientEntity updateClient(Long id, ClientEntity client, String detail);

    String deleteClient(Long id, String detail);
}

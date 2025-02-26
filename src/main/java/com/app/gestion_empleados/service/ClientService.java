package com.app.gestion_empleados.service;

import com.app.gestion_empleados.persistence.entity.ClientEntity;

import java.util.List;

public interface ClientService
{
    ClientEntity saveClient(ClientEntity client);

    List<ClientEntity> getClients();

    ClientEntity getClient(Long id);

    ClientEntity updateClient(Long id, ClientEntity client);

    String deleteClient(Long id);
}

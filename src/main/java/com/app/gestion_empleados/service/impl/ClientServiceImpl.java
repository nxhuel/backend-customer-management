package com.app.gestion_empleados.service.impl;

import com.app.gestion_empleados.exception.ResourceNotFoundException;
import com.app.gestion_empleados.persistence.entity.ClientEntity;
import com.app.gestion_empleados.persistence.entity.ClientHistory;
import com.app.gestion_empleados.persistence.repository.ClientHistoryRepository;
import com.app.gestion_empleados.persistence.repository.ClientRepository;
import com.app.gestion_empleados.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientHistoryRepository clientHistoryRepository;

    @Override
    public ClientEntity saveClient(ClientEntity client, String detail)
    {
        ClientEntity newClient = clientRepository.save(client);

        ClientHistory clientHistory = new ClientHistory();
        clientHistory.setAction("Agregado");
        clientHistory.setDetail(detail);
        clientHistory.setDate(new Date());
        clientHistory.setClient(newClient);

        clientHistoryRepository.save(clientHistory);

        return newClient;
    }

    @Override
    public List<ClientEntity> getClients()
    {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity getClient(Long id)
    {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The client with that ID does not exist: " + id));
        return client;
    }

    @Override
    public ClientEntity updateClient(Long id, ClientEntity client, String detail)
    {
        ClientEntity oldClient = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The client with that ID does not exist: " + id));

        oldClient.setName(client.getName());
        oldClient.setLastname(client.getLastname());
        oldClient.setEmail(client.getEmail());

        ClientEntity updatedClient = clientRepository.save(oldClient);

        ClientHistory clientHistory = new ClientHistory();
        clientHistory.setAction("Modificado");
        clientHistory.setDetail(detail);
        clientHistory.setDate(new Date());
        clientHistory.setClient(updatedClient);

        clientHistoryRepository.save(clientHistory);

        return updatedClient;
    }

    @Override
    public String deleteClient(Long id, String detail)
    {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The client with that ID does not exist: " + id));

        ClientHistory clientHistory = new ClientHistory();
        clientHistory.setAction("Eliminado");
        clientHistory.setDetail(detail);
        clientHistory.setDate(new Date());
        clientHistory.setClientName(client.getName());
        clientHistory.setClientLastname(client.getLastname());
        clientHistory.setClient(null);

        clientHistoryRepository.save(clientHistory);

        clientHistoryRepository.deleteByClientId(client.getId());
        clientRepository.deleteById(client.getId());

        return "Client deleted successfully";
    }
}

package com.app.gestion_empleados.service.impl;

import com.app.gestion_empleados.exception.ResourceNotFoundException;
import com.app.gestion_empleados.persistence.entity.ClientEntity;
import com.app.gestion_empleados.persistence.repository.ClientRepository;
import com.app.gestion_empleados.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientEntity saveClient(ClientEntity client)
    {
        return clientRepository.save(client);
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
    public ClientEntity updateClient(Long id, ClientEntity client)
    {
        ClientEntity oldClient = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The client with that ID does not exist: " + id));

        oldClient.setName(client.getName());
        oldClient.setLastname(client.getLastname());
        oldClient.setEmail(client.getEmail());

        ClientEntity updatedClient = clientRepository.save(oldClient);
        return updatedClient;
    }

    @Override
    public String deleteClient(Long id)
    {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The client with that ID does not exist: " + id));

        clientRepository.deleteById(client.getId());
        return "Client deleted successfully";
    }
}

package com.app.gestion_empleados.controller;

import com.app.gestion_empleados.persistence.entity.ClientHistory;
import com.app.gestion_empleados.persistence.repository.ClientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientHistoryController
{
    @Autowired
    private ClientHistoryRepository clientHistoryRepository;

    @GetMapping("/history")
    public List<ClientHistory> getHistory() {
        return clientHistoryRepository.findAll();
    }

    @GetMapping("/history/{clientId}")
    public List<ClientHistory> getHistoryByClient(@PathVariable Long clientId)
    {
        return clientHistoryRepository.findByClientId(clientId);
    }
}

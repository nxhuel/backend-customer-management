package com.app.gestion_empleados.controller;

import com.app.gestion_empleados.dto.ClientRequest;
import com.app.gestion_empleados.persistence.entity.ClientEntity;
import com.app.gestion_empleados.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class ClientController
{
    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<ClientEntity> saveClient(@RequestBody ClientRequest request)
    {
        return new ResponseEntity<>(clientService.saveClient(request.getClient(), request.getDetail()), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientEntity>> getClients()
    {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientEntity> getClient(@PathVariable Long id)
    {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable Long id, @RequestBody ClientRequest request)
    {
        return new ResponseEntity<>(clientService.updateClient(id, request.getClient(), request.getDetail()), HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id, @RequestBody ClientRequest request)
    {
        return new ResponseEntity<>(clientService.deleteClient(id, request.getDetail()), HttpStatus.OK);
    }
}

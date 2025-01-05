package com.msoft.projectmanagementsystem.controller;

import com.msoft.projectmanagementsystem.Exception.CustomException;
import com.msoft.projectmanagementsystem.model.Client;
import com.msoft.projectmanagementsystem.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created On:1/5/25 12:02 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final ClientService clientService;

    public CompanyController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        try {
            Client addedClient = clientService.addClient(client);
            return new ResponseEntity<>(addedClient, HttpStatus.CREATED);
        }catch (Exception e){
            throw new CustomException("Error adding client: "+ e.getMessage());
        }
    }
    @GetMapping("/clientList/{companyId}")
    public ResponseEntity<List<Client>> getClientsByCompanyId(@PathVariable Long companyId){
        try {
            List<Client> clientList = clientService.getClientsByCompanyId(companyId);
            return new ResponseEntity<>(clientList, HttpStatus.CREATED);
        }catch(Exception e){
            throw new CustomException("Error Fetching Cilent: "+e.getMessage());
        }
    }


}

package com.msoft.projectmanagementsystem.service;

import com.msoft.projectmanagementsystem.model.Client;
import com.msoft.projectmanagementsystem.repo.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created On:1/2/25 5:29 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Service
public class ClientService {
    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    public Client addClient(Client client){
        return clientRepo.save(client);
    }

    public List<Client> getClientsByCompanyId(Long companyId) {
        return clientRepo.getClientsByCompanyId(companyId);
    }
}

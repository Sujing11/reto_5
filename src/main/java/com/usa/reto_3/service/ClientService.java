package com.usa.reto_3.service;

import com.usa.reto_3.dbo.ClientDbo;
import com.usa.reto_3.dbo.ReportClientsDbo;
import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public Optional<ClientModel> obtenerPorId(int id) {
        return clientRepository. findById(id);
    }

    public void crear(ClientModel client) {
        if (!clientRepository.existsById(client.getIdClient())) {
            clientRepository.save(client);
        }
    }

    public void actualizar(ClientDbo clientInput) {
        Optional<ClientModel> clientDb = clientRepository.findById(clientInput.getIdClient());
        if(clientDb.isPresent()){
            ClientModel client = clientDb.get();
            if(clientInput.getAge() != null){
                client.setAge(clientInput.getAge());
            }
            if(clientInput.getName() != null){
                client.setName(clientInput.getName());
            }
            if(clientInput.getEmail() != null){
                client.setEmail(clientInput.getEmail());
            }
            if(clientInput.getPassword() != null){
                client.setPassword(clientInput.getPassword());
            }
            clientRepository.save(client);
        }
    }

    public void eliminar(int id) {
        clientRepository.deleteById(id);
    }

    public List<ReportClientsDbo> reportClients() {
        List<ReportClientsDbo> listReportClients = new LinkedList<>();
        List<ClientModel> listClient = clientRepository.reportClients();
        for (ClientModel client : listClient) {
            int countReservation = client.getReservations().size();
            listReportClients.add(new ReportClientsDbo(countReservation,client));
        }
        return listReportClients;
    }

}

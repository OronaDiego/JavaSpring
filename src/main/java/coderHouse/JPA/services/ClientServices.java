package coderHouse.JPA.services;

import coderHouse.JPA.entities.Client;
import coderHouse.JPA.reposotories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // informo que esta clase es un servicio para luego poder inyectarlo en cualquier parte de nuestro programa
public class ClientServices {
    @Autowired   //Esta anotacion es para inyectar la dependencia
    private ClientRepository clientRepository;

    public void saveClient(Client clients){
      this.clientRepository.save(clients);
    }
    public Optional<Client> getClient(Integer id){
        return this.clientRepository.findById(id);
    }

    public List<Client> getClient(){
        return this.clientRepository.findAll();
    }
    public Optional<Client> updateClient(Integer id, Client client){
        Optional<Client> clientDB= this.clientRepository.findById(id);

        if(clientDB.isEmpty()){
            return Optional.empty();
        }
        clientDB.get().setName(client.getName());
        clientDB.get().setLastname(client.getLastname());
        clientDB.get().setDocNumber(client.getDoc_number());

        this.clientRepository.save(clientDB.get());
        return clientDB;
    }

    public Optional<Client> deleteClient(Integer id){
        Optional<Client> clientDB= this.clientRepository.findById(id);

        if(clientDB.isEmpty()){
            return Optional.empty();
        }
        this.clientRepository.deleteById(id);
        return clientDB;
    }
}

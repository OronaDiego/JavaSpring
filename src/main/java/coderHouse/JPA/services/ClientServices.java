package coderHouse.JPA.services;

import coderHouse.JPA.entities.Client;
import coderHouse.JPA.reposotories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // informo que esta clase es un servicio para luego poder inyectarlo en cualquier parte de nuestro programa
public class ClientServices {
    @Autowired   //Esta anotacion es para inyectar la dependencia
    private ClientRepository clientRepository;

    //private final JdbcTemplate jdbc;  // eso no permite trabajar con el Driver de Java
    //public ClientServices(JdbcTemplate jdbc){
    //    this.jdbc = jdbc;
    //}

    public void saveClient(Client clients){
      this.clientRepository.save(clients);
    }
    public List<Client> getClient(){
        return this.clientRepository.findAll();
    }
}

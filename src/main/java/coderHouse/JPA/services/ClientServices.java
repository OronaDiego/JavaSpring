package coderHouse.JPA.services;

import coderHouse.JPA.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // informo que esta clase es un servicio para luego poder inyectarlo en cualquier parte de nuestro programa
public class ClientServices {
    @Autowired   //Esta anotacion es para inyectar la dependencia
    private final JdbcTemplate jdbc;  // eso no permite trabajar con el Driver de Java

    public ClientServices(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void saveClient(Client clients){
        this.jdbc.update(
                "INSERT INTO client (name, lastname, doc_number) VALUES(?,?,?)",
                clients.getName(),
                clients.getLastname(),
                clients.getDoc_number()
        );
    }
    public List<Client> getClient(){
        return this.jdbc.query(
                "SELECT * FROM client",
                (rs,rowNum) -> new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("doc_number")
                )
        );
    }
}

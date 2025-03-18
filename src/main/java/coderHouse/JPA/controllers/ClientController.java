package coderHouse.JPA.controllers;

import coderHouse.JPA.entities.Client;
import coderHouse.JPA.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Mediante esta anotacion defino que esta clase va a ser un controlador
@RequestMapping("/clients") // aca indico la direccion para acceder a este controlador
public class ClientController {

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices){
        this.clientServices = clientServices;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(this.clientServices.getClient());
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        this.clientServices.saveClient(client);
        return ResponseEntity.ok(client);
    }

}

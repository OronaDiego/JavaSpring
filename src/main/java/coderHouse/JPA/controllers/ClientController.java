package coderHouse.JPA.controllers;

import coderHouse.JPA.entities.Client;
import coderHouse.JPA.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClient(@PathVariable Integer id){
        Optional<Client> client = this.clientServices.getClient(id);

        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        try{
            this.clientServices.saveClient(client);
            return ResponseEntity.ok(client);
        }catch (Error error){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Optional<Client>> updateClient(@PathVariable Integer id,@RequestBody Client client){
        Optional<Client> newClient = this.clientServices.updateClient(id, client);

        if(newClient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Client>> deleteClient(@PathVariable Integer id){
        Optional<Client> client = this.clientServices.deleteClient(id);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }


}

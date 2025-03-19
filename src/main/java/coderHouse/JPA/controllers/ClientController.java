package coderHouse.JPA.controllers;

import coderHouse.JPA.entities.Client;
import coderHouse.JPA.services.ClientServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "obtengo todos los clients", description = "Obtengo una lista de los clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "SuccessFul operation"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(this.clientServices.getClient());
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtengo todos los clients por id", description = "Obtengo una lista de los clientes mediante ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "SuccessFul operation"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
    })
    public ResponseEntity<Optional<Client>> getClient(@PathVariable Integer id){
        Optional<Client> client = this.clientServices.getClient(id);

        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping(consumes = "application/json")
    @Operation(summary = "Creo un nuevo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created Client Successfully"),
            @ApiResponse(responseCode = "400",description = "Bad Request")
    })
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        try{
            this.clientServices.saveClient(client);
            return ResponseEntity.ok(client);
        }catch (Error error){
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping(value = "/{id}", consumes = "application/json")
    @Operation(summary = "Actualizo Clientes- ID", description = "Actualizo Clientes por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "201",description = "Update SuccessFul"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
    })
    public ResponseEntity<Optional<Client>> updateClient(@PathVariable Integer id,@RequestBody Client client){
        Optional<Client> newClient = this.clientServices.updateClient(id, client);

        if(newClient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newClient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borro Cliente-ID", description = "Borro Clientes por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = " Delete SuccessFul"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
    })
    public ResponseEntity<Optional<Client>> deleteClient(@PathVariable Integer id){
        Optional<Client> client = this.clientServices.deleteClient(id);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }


}

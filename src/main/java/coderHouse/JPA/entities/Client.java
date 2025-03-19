package coderHouse.JPA.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
//@Data
//@NoArgsConstructor  // Genera constructor vacío (requerido por JPA)
//@AllArgsConstructor // Genera constructor con todos los atributos
//No me funcionaron con lombook
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(defaultValue = "ClientID", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int id;

    @Column(nullable = false)
    @Schema(defaultValue = "ClientName", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan")
    private String name;

    @Column(nullable = false)
    @Schema(defaultValue = "ClientLastName", requiredMode = Schema.RequiredMode.REQUIRED, example = "Perez")
    private String lastname;

    @Column(nullable = false, unique = true)
    @Schema(defaultValue = "ClientDocNumber", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private String doc_number;

    public Client(int id, String name, String lastname, String doc_number) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.doc_number = doc_number;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDocNumber(String docNumber) {
        this.doc_number = doc_number;
    }
    //Getter y Setters Para acceder y modificar los atributos privados de la clase.
    //Con lombook no es necesario crear Getter Y Setter ya que con @data los genera automaticamente


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval es para que que se eliminen las facturas si se borra el cliente.
    private List<Invoice> invoices = new ArrayList<>(); //lo inicializo como array para evitar NullPointerException cuando no haya facturas asociadas.
}

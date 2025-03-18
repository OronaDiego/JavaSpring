package coderHouse.JPA.entities;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String doc_number;

    public Client(int id, String name, String lastname, String doc_number) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.doc_number = doc_number;
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

package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor  // Genera constructor vacío (requerido por JPA)
@AllArgsConstructor // Genera constructor con todos los atributos
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String docNumber;

    //Getter y Setters Para acceder y modificar los atributos privados de la clase.
    //Con lombook no es necesario crear Getter Y Setter ya que con @data los genera automaticamente


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval es para que que se eliminen las facturas si se borra el cliente.
    private List<Invoice> invoices = new ArrayList<>(); //lo inicializo como array para evitar NullPointerException cuando no haya facturas asociadas.
}

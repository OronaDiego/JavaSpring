package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data // genera Getter y Setter de manera automatica con lombook
@NoArgsConstructor  // Genera constructor vacío (requerido por JPA) mediante lombook
@AllArgsConstructor // Genera constructor con todos los atributos mediante lombook
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Aseguro que cada factura tenga un cliente
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false) // Se setea solo al crear la factura
    private Date createdAt = new Date(); // Se inicializa con la fecha actual

    private double total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details= new ArrayList<>();
}
package coderHouse.JPA.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(defaultValue = "IdFactura", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Aseguro que cada factura tenga un cliente
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false) // Se setea solo al crear la factura
    @Schema(defaultValue = "FechaFac", requiredMode = Schema.RequiredMode.AUTO, example = "2025-03-19")
    private Date createdAt = new Date(); // Se inicializa con la fecha actual

    @Schema(defaultValue = "TotalFac", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.9")
    private double total;

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public double getTotal() {
        return total;
    }

    public List<InvoiceDetail> getDetails() {
        return details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDetails(List<InvoiceDetail> details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details= new ArrayList<>();
}
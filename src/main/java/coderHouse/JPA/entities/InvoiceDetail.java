package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_details")
@Data // genera Getter y Setters
@NoArgsConstructor // genera constructor Vacio olbigatorio por JPA, mediante lombook
@AllArgsConstructor //Genera constructor con todos los atributos mediante lombook
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Se cambia de invoiceDetailId a id por convención

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false) // No puede haber detalle sin factura)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // No puede haber detalle sin producto)
    private Product product;

    @Column(nullable = false) //Evita valores null en la base de datos.
    private int amount;

    @Column(nullable = false) //Evita valores null en la base de datos.
    private double price;
}
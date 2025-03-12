package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "invoice_details")
@Data
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceDetailId;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;
    private double price;
}
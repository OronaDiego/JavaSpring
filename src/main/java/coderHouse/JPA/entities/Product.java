package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String code;
    private int stock;
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;
}

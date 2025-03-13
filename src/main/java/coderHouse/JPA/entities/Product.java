package coderHouse.JPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data  // genera de manera automatica Getter y Setters con lombook
@NoArgsConstructor  // genera un constructor vacio requerido por JPA mediante lombook
@AllArgsConstructor //Genera constructor con todos los atributos mediante lombook
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true) // Me aseguro que el codigo sea unico
    private String code;

    @NotNull //Evito valores negativos o nulos.
    @Positive
    private int stock;

    @NotNull //Evito valores negativos o nulos.
    @Positive
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();
}

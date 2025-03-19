package coderHouse.JPA.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(defaultValue = "idProduct", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int id;

    @Column(nullable = false)
    @Schema(defaultValue = "ProductDesc", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Resistente al agua")
    private String description;

    @Column(nullable = false, unique = true) // Me aseguro que el codigo sea unico
    @Schema(defaultValue = "ProductCode", requiredMode = Schema.RequiredMode.REQUIRED, example = "A100")
    private String code;

    @NotNull //Evito valores negativos o nulos.
    @Positive
    @Schema(defaultValue = "ProductStock", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private int stock;

    @NotNull //Evito valores negativos o nulos.
    @Positive
    @Schema(defaultValue = "ProducPrecio", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.9")
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();
}

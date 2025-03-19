package coderHouse.JPA.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(defaultValue = "IdDetalleFac", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private int id; // Se cambia de invoiceDetailId a id por convención

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false) // No puede haber detalle sin factura)
    @Schema(defaultValue = "factura", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // No puede haber detalle sin producto)
    @Schema(defaultValue = "Product", requiredMode = Schema.RequiredMode.REQUIRED, example = "Repelente OFF")
    private Product product;

    @Column(nullable = false) //Evita valores null en la base de datos.
    @Schema(defaultValue = "Monto", requiredMode = Schema.RequiredMode.REQUIRED, example = "99")
    private int amount;

    @Column(nullable = false) //Evita valores null en la base de datos.
    @Schema(defaultValue = "Precio", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.9")
    private double price;
}
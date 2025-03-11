package coderHouse.JPA.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;
    private String docNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}

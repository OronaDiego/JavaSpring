package coderHouse.JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name= "ALUMNO")
public class Alumno {

        @Column(name = "NOMBRE")
        private String nombre;

        @Column(name= "APELLIDO")
        private String apellido;

        @Column(name= "DNI")
        private int dni;

        @Column(name = "LEGAJO")
        private int legajo;


}

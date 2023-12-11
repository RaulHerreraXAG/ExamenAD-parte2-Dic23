package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Raúl Herrera Alba
 * Fecha: 11-12-2023
 */


@Entity
@Table(name = "garaje")
@Getter
@Setter
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula")
    private String plate;

    @Column(name = "modelo")
    private String model;

    @Column(name = "fabricante")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Client client;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + Client.class +
                '}';
    }

}

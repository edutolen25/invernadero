package demo.Invernadero.lalo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "control")

public class Control {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_control;
    private String fecha;
    private String hora;
    private String sensor_humedad;
    private String sensor_temperatura;
    private String ventilacion;
}

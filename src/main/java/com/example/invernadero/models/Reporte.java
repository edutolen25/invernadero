package demo.Invernadero.lalo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reporte")

public class Reporte{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reporte;
    private String fecha;
    private String hora;
    private String id_usuario;
    private String nombre;
    private String observaciones;
}



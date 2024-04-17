package demo.Invernadero.lalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.invernadero.models.Reporte;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}
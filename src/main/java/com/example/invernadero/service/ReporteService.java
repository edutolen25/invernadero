package demo.Invernadero.lalo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.invernadero.models.Reporte;
import com.example.invernadero.repository.ReporteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> getAllReporte() {
        return reporteRepository.findAll();
    }

    public Optional<Reporte> getReporteById(Long id) {
        return reporteRepository.findById(id);
    }

    public Reporte saveReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte updateReporte(Long id, Reporte newReporte) {
        return reporteRepository.findById(id)
                .map(reporte -> {
                    reporte.setFecha(newReporte.getFecha());
                    reporte.setHora(newReporte.getHora());
                    reporte.setId_usuario(newReporte.getId_usuario());
                    reporte.setNombre(newReporte.getNombre());
                    reporte.setObservaciones(newReporte.getObservaciones());
                    return reporteRepository.save(reporte);
                })
                .orElse(null);
    }

    public void deleteReporte(Long id) {
        reporteRepository.deleteById(id);
    }
}

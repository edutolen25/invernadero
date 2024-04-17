package demo.Invernadero.lalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.invernadero.models.Reporte;
import com.example.invernadero.service.ReporteService;

@RestController
@RequestMapping("api/controlinvernadero/v1/reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> getAllReporte() {
        List<Reporte> reporte = reporteService.getAllReporte();
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable Long id) {
        Optional<Reporte> reporte = reporteService.getReporteById(id);
        return reporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reporte> saveReporte(@RequestBody Reporte reporte) {
        Reporte saveReporte = reporteService.saveReporte(reporte);
        return new ResponseEntity<>(saveReporte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> updateReporte(@PathVariable Long id, @RequestBody Reporte newReporte) {
        Reporte updateReporte = reporteService.updateReporte(id, newReporte);
        return new ResponseEntity<>(updateReporte, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reporteService.deleteReporte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package demo.Invernadero.lalo.service;

import com.example.invernadero.dto.VerreporteDTO;
import com.example.invernadero.repository.VerreporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerreporteService {

    @Autowired
    private VerreporteRepository verreporteRepository;

    public List<VerreporteDTO> getAllVerreporte() {
        return verreporteRepository.findAllCustom();
    }
}

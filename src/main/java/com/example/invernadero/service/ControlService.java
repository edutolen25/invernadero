package demo.Invernadero.lalo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.invernadero.models.Control;
import com.example.invernadero.repository.ControlRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ControlService {

    @Autowired
    private ControlRepository controlRepository;

    public List<Control> getAllControl() {
        return controlRepository.findAll();
    }

    public Optional<Control> getControlById(Long id) {
        return controlRepository.findById(id);
    }

    public Control saveControl(Control control) {
        return controlRepository.save(control);
    }

    public Control updateControl(Long id, Control newControl) {
        return controlRepository.findById(id)
                .map(control -> {
                    control.setFecha(newControl.getFecha());
                    control.setHora(newControl.getHora());
                    control.setSensor_humedad(newControl.getSensor_humedad());
                    control.setSensor_temperatura(newControl.getSensor_temperatura());
                    control.setVentilacion(newControl.getVentilacion());
                    return controlRepository.save(control);
                })
                .orElse(null);
    }

    public void deleteControl(Long id) {
        controlRepository.deleteById(id);
    }
}

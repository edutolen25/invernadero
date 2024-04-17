package demo.Invernadero.lalo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.invernadero.models.Control;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {
}
package com.example.medico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medico.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{
    
}

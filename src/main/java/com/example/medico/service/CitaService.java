package com.example.medico.service;
import com.example.medico.model.Cita;
import java.util.List;
import java.util.Map;

public interface CitaService {
    List<Cita> getAllCitas();
    Cita createCita(Cita cita);
    void deleteCita(long id );
    List<Map<String, String>> getAllHoraCitaAndDisponibilidades();

    
}

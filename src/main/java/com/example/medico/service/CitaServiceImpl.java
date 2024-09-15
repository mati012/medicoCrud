package com.example.medico.service;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.medico.model.Cita;
import com.example.medico.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Override
    public List<Cita> getAllCitas(){
        return citaRepository.findAll();
    }
    @Override
    public Cita createCita(Cita cita){
        return citaRepository.save(cita);

    }

    @Override
    public void  deleteCita(long id){
        citaRepository.deleteById(id);
    }
    @Override
    public List<Map<String, String>> getAllHoraCitaAndDisponibilidades() {
        return citaRepository.findAll().stream()
            .map(c -> Map.of(
                "horaCita", c.getHoraCita(),
                "disponibilidad", c.getDisponibilidad()
            ))
            .collect(Collectors.toList());
    }
}

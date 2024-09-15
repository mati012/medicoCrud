package com.example.medico.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.swing.text.html.parser.Entity;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.medico.model.Cita;
import com.example.medico.service.CitaService;




@RestController
@RequestMapping("/citas")
public class CitaController {

    private static final Logger log = LoggerFactory.getLogger(CitaController.class);

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getCitaAllCitas() {
        log.info("GET/citas");
        log.info("retorna todas las citas ");
        return citaService.getAllCitas();
    }
    @PostMapping
    public Cita createCita(@RequestBody Cita cita){
        log.info("POST/citas");
        log.info("crea una cita  ");
        return citaService.createCita(cita);
    }
    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id){
        log.info("GET/citas/{id}");
        log.info("retorna una cita por id  ");
         citaService.deleteCita(id);
    }
    @GetMapping("/info")
    public List<Map<String, String>> getAllHoraCitaAndDisponibilidades() {
        log.info("GET/citas/info");
        log.info("retorna todas las citas y dispobonibilidades   ");
        return citaService.getAllHoraCitaAndDisponibilidades();
    }
}

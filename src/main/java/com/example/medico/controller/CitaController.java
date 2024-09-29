package com.example.medico.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.medico.model.Cita;
import com.example.medico.service.CitaService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private static final Logger log = LoggerFactory.getLogger(CitaController.class);

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<EntityModel<Cita>>> getAllCitas() {
        log.info("GET/citas");
        log.info("retorna todas las citas ");
        List<Cita> citas = citaService.getAllCitas();
        List<EntityModel<Cita>> citasModel = citas.stream()
                .map(cita -> EntityModel.of(cita,
                        WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).withRel("citas")))
                .toList();
        return ResponseEntity.ok(citasModel);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Cita>> createCita(@RequestBody Cita cita) {
        log.info("POST/citas");
        log.info("crea una cita");
        Cita nuevaCita = citaService.createCita(cita);
        EntityModel<Cita> citaModel = EntityModel.of(nuevaCita,
                WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).withRel("citas"));

        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).toUri())
                .body(citaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCita(@PathVariable Long id) {
        log.info("DELETE/citas/{id}");
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/info")
    public ResponseEntity<List<EntityModel<Map<String, String>>>> getAllHoraCitaAndDisponibilidades() {
        log.info("GET/citas/info");
        log.info("retorna todas las citas y disponibilidades");
        List<Map<String, String>> citasInfo = citaService.getAllHoraCitaAndDisponibilidades();
        List<EntityModel<Map<String, String>>> citasInfoModel = citasInfo.stream()
                .map(info -> EntityModel.of(info,
                        WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllHoraCitaAndDisponibilidades()).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(methodOn(CitaController.class).getAllCitas()).withRel("citas")))
                .toList();
        return ResponseEntity.ok(citasInfoModel);
    }
}

package com.example.medico.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.medico.model.Cita;

import com.example.medico.repository.CitaRepository;
import com.example.medico.controller.CitaController;
import com.example.medico.service.*;;


@ExtendWith(MockitoExtension.class)
public class CitaControllerTest {

    @Mock
    private CitaService citaService; // Mock de CitaService

    @InjectMocks
    private CitaController citaController; // Inyecta el mock en el controlador

    @Test
    void testGetAllHoraCitaAndDisponibilidades() {
        // Arrange
        List<Map<String, String>> citasInfo = List.of(Map.of("hora", "10:00", "disponibilidad", "true"));
        when(citaService.getAllHoraCitaAndDisponibilidades()).thenReturn(citasInfo);

        // Act
        ResponseEntity<List<EntityModel<Map<String, String>>>> response = citaController.getAllHoraCitaAndDisponibilidades();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(citasInfo.get(0), response.getBody().get(0).getContent());
    }


    @Test
    void testDeleteCita() {
    // Arrange
    Long id = 1L;

    // Act
    ResponseEntity<?> response = citaController.deleteCita(id);

    // Assert
    verify(citaService, times(1)).deleteCita(id); // Verifica que se llama al servicio una vez
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
}
    @Test
    void testCreateCita() {
    // Arrange
    Cita cita = new Cita(); // Crear una instancia de Cita para la prueba
    Cita nuevaCita = new Cita(); // Resultado esperado
    when(citaService.createCita(cita)).thenReturn(nuevaCita);
    
    // Act
    ResponseEntity<EntityModel<Cita>> response = citaController.createCita(cita);

    // Assert
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(nuevaCita, response.getBody().getContent());
    assertNotNull(response.getBody().getLinks());
}



    
}

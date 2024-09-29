package com.example.medico.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.medico.model.Cita;
import com.example.medico.repository.CitaRepository;
import com.example.medico.service.*;

@ExtendWith(MockitoExtension.class) 
public class CitaServiceTest {
    

 @Mock
    private CitaRepository citaRepository; 

    @InjectMocks
    private CitaServiceImpl citaService;
    @Test
    void testGetAllCitas() {
        // Arrange
        List<Cita> citas = List.of(new Cita(), new Cita()); 
        when(citaRepository.findAll()).thenReturn(citas); 

        // Act
        List<Cita> result = citaService.getAllCitas();

        // Assert
        assertEquals(2, result.size()); 
        assertEquals(citas, result); 
    }

@Test
void testCreateCita() {
    // Arrange
    Cita cita = new Cita(); 
    when(citaRepository.save(cita)).thenReturn(cita); 

    // Act
    Cita result = citaService.createCita(cita);

    // Assert
    assertNotNull(result); 
    assertEquals(cita, result); 
    verify(citaRepository, times(1)).save(cita); 
}

@Test
void testDeleteCita() {
    // Arrange
    Long id = 1L;

    // Act
    citaService.deleteCita(id);

    // Assert
    verify(citaRepository, times(1)).deleteById(id); 
}


}

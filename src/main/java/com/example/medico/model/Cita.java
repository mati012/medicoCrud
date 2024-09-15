package com.example.medico.model;
import java.util.List;
import java.util.Map;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message="No se puede ingresar sin fecha ")
    @Column(name="fechaCita")
    private String fechaCita;
    @NotBlank(message="No se puede ingresar sin hora ")
    @Column(name="horaCita")
    private String horaCita;
    @NotBlank(message="No se puede ingresar sin doctor ")
    @Column(name= "doctor")
    private String doctor;
    @NotBlank(message="No se puede ingresar sin centro medico")
    @Column(name= "centroMedico")
    private String centroMedico;
    @NotBlank(message="No se puede ingresar sin disponibilidad ")
    @Column(name="disponibilidad")
    private String disponibilidad;

    
    public String getHoraCita() {
        return horaCita;
    }
    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getCentroMedico() {
        return centroMedico;
    }
    public void setCentroMedico(String centroMedico) {
        this.centroMedico = centroMedico;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }


}
package com.udea.ultimo.Persistance.Repository;

import com.udea.ultimo.Persistance.Model.HistoriaClinica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica,Integer> {


    @Query("SELECT u FROM HistoriaClinica u WHERE u.cedulaPaciente = ?1")
    List<HistoriaClinica> findHistoriaClinicaByPaciente(String cedulaPaciente);
    @Query("SELECT u FROM HistoriaClinica u WHERE u.cedulaMedico = ?1")
    List<HistoriaClinica> findHistoriaClinicaByMedico(String cedulaMedico);
    
}

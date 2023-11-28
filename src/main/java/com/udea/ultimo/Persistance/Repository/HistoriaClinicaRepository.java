package com.udea.ultimo.Persistance.Repository;

import com.udea.ultimo.Persistance.Model.HistoriaClinica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica,String> {
}

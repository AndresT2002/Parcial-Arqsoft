package com.udea.ultimo.Persistance.Repository;


import com.udea.ultimo.Persistance.Model.HistoriaClinica;
import com.udea.ultimo.Persistance.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,String> {

    @Query("SELECT u FROM Medico u WHERE u.cedula = ?1")
    Optional<Medico> findByCedula(String cedulaMedico);

}

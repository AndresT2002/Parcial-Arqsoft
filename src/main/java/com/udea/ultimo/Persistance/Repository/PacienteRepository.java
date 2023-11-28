package com.udea.ultimo.Persistance.Repository;
import com.udea.ultimo.Persistance.Model.Medico;
import com.udea.ultimo.Persistance.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,String> {

    @Query("SELECT u FROM Paciente u WHERE u.cedula = ?1")
    Optional<Paciente> findByCedula(String cedulaPaciente);
}

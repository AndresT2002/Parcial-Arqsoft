package com.udea.ultimo.Persistance.Repository;
import com.udea.ultimo.Persistance.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,String> {


}

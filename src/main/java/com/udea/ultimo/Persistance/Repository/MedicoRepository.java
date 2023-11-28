package com.udea.ultimo.Persistance.Repository;


import com.udea.ultimo.Persistance.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,String> {
}

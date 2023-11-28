package com.udea.ultimo.Service.Paciente;

import com.udea.ultimo.Persistance.Model.Paciente;
import com.udea.ultimo.Persistance.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements  IPacienteService{


    @Autowired
    PacienteRepository  pacienteRepository;

    @Override
    public Boolean pacienteExist(String cedula) {
        Optional<Paciente> paciente= pacienteRepository.findByCedula(cedula);

        return paciente.isPresent();
    }


}

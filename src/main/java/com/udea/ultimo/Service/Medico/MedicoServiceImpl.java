package com.udea.ultimo.Service.Medico;

import com.udea.ultimo.Persistance.Model.Medico;
import com.udea.ultimo.Persistance.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoServicio{


    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Boolean medicoExist(String cedula) {

        Optional<Medico> medico= medicoRepository.findByCedula(cedula);

        return medico.isPresent();

    }


}

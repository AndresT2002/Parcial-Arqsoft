package com.udea.ultimo.Service.HistoriaClinica;
import com.udea.ultimo.Persistance.Model.Medico;
import com.udea.ultimo.Persistance.Model.HistoriaClinica;
import com.udea.ultimo.Persistance.Model.Paciente;
import com.udea.ultimo.Persistance.Repository.HistoriaClinicaRepository;
import com.udea.ultimo.Persistance.Repository.MedicoRepository;
import com.udea.ultimo.Persistance.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HistoriaClinicaServiceImpl implements  IHistoriaClinicaService{


    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {

        //Mirar si existe paciente y medico

        Optional<Medico> medico = medicoRepository.findByCedula(historiaClinica.getCedulaMedico());
        Optional<Paciente> paciente = pacienteRepository.findByCedula(historiaClinica.getCedulaPaciente());
        if(paciente.isPresent() && medico.isPresent() ) {
            HistoriaClinica result =  historiaClinicaRepository.save(historiaClinica);
            return result;
        }

        return null;
    }

    @Override
    public List<HistoriaClinica> historiaClinicaPorPaciente(String cedulaPaciente) {
        return historiaClinicaRepository.findHistoriaClinicaByPaciente(cedulaPaciente);
    }



    @Override
    public List<HistoriaClinica> historiaClinicaPorMedico(String cedulaMedico) {
        return historiaClinicaRepository.findHistoriaClinicaByMedico(cedulaMedico);
    }


}

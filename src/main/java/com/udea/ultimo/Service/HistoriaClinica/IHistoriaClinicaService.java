package com.udea.ultimo.Service.HistoriaClinica;

import com.udea.ultimo.Persistance.Model.HistoriaClinica;

import java.util.List;

public interface IHistoriaClinicaService {

    HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica);

    List<HistoriaClinica> historiaClinicaPorPaciente(String cedulaPaciente);

    List<HistoriaClinica> historiaClinicaPorMedico(String cedulaMedico);

}

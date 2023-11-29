package com.udea.ultimo.Controller;

import com.udea.ultimo.Config.ApiVersion;
import com.udea.ultimo.Persistance.Model.HistoriaClinica;
import com.udea.ultimo.Service.HistoriaClinica.IHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Historia Clínica Controller", tags = "Historia Clínica")
@RequestMapping(ApiVersion.V1_API + "/history")
public class HistoryController {

    @Autowired
    private IHistoriaClinicaService historyService;

    @GetMapping(path = "/paciente/{cedula}", produces = "application/json;version=1")
    @ApiOperation(value = "Obtener Historia Clínica por Cédula de un paciente", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historia Clínica encontrada correctamente"),
            @ApiResponse(code = 404, message = "Historia Clínica no encontrada para la cédula proporcionada")
    })
    public List<HistoriaClinica> historiaClinica(
            @ApiParam(value = "Cédula del paciente", required = true) @PathVariable String cedula) {
        return historyService.historiaClinicaPorPaciente(cedula);
    }

    @GetMapping(path = "/doctor/{cedula}", produces = "application/json;version=1")
    @ApiOperation(value = "Obtener Historia Clínica por Cédula de un médico", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historia Clínica encontrada correctamente"),
            @ApiResponse(code = 404, message = "Historia Clínica no encontrada para la cédula proporcionada")
    })
    public List<HistoriaClinica> historiaClinicaDoctor(
            @ApiParam(value = "Cédula del médico", required = true) @PathVariable String cedula) {
        return historyService.historiaClinicaPorMedico(cedula);
    }

    @PostMapping(path = "/paciente", produces = "application/json;version=1")
    @ApiOperation(value = "Ingresar Historia Clínica", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Historia Clínica creada exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud inválida")
    })
    public HistoriaClinica ingresarHistoria(
            @ApiParam(value = "Datos de la Historia Clínica", required = true) @RequestBody HistoriaClinica historiaClinica) {
        return historyService.crearHistoriaClinica(historiaClinica);
    }

}

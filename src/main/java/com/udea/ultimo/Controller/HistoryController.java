package com.udea.ultimo.Controller;

import com.udea.ultimo.Config.ApiVersion;
import com.udea.ultimo.Persistance.Model.HistoriaClinica;
import com.udea.ultimo.Service.HistoriaClinica.IHistoriaClinicaService;
import com.udea.ultimo.Service.HistoriaClinica.IMedicoServicio;
import com.udea.ultimo.Service.HistoriaClinica.IPacienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IMedicoServicio medicoService;

    @GetMapping(path = "/paciente/{cedula}", produces = "application/json;version=1")
    @ApiOperation(value = "Obtener Historia Clínica por Cédula de un paciente", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historia Clínica encontrada correctamente"),
            @ApiResponse(code = 404, message = "paciente no encontrado para la cédula proporcionada"),
            @ApiResponse(code = 204, message = "Historia Clínica no encontrada para la cédula proporcionada")
    })
    public ResponseEntity<?> historiaClinica(
            @ApiParam(value = "Cédula del paciente", required = true) @PathVariable String cedula) {
        if (!pacienteService.pacienteExist(cedula)) {
            return ResponseEntity.notFound().build();
        }
        
        List<HistoriaClinica> historiaClinica = historyService.historiaClinicaPorPaciente(cedula);
        if (historiaClinica.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(historiaClinica);
    }



    }

    @GetMapping(path = "/medico/{cedula}", produces = "application/json;version=1")
    @ApiOperation(value = "Obtener Historia Clínica por Cédula de un médico", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historia Clínica encontrada correctamente"),
            @ApiResponse(code = 404, message = "Medico no encontrado para la cédula proporcionada"),
            @ApiResponse(code = 204, message = "Historia Clínica no encontrada para la cédula proporcionada")
    })
    public ResponseEntity<?> historiaClinicaDoctor(
            @ApiParam(value = "Cédula del médico", required = true) @PathVariable String cedula) {

        if (!medicoService.medicoExist(cedula)) {
            return ResponseEntity.notFound().build();
        }
        List<HistoriaClinica> historiaClinica = historyService.historiaClinicaPorMedico(cedula);
        if (historiaClinica.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historiaClinica);

    }

    @PostMapping(path = "/paciente", produces = "application/json;version=1")
    @ApiOperation(value = "Ingresar Historia Clínica", response = HistoriaClinica.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Historia Clínica creada exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud inválida")
    })
    public ResponseEntity<?> ingresarHistoria(
            @ApiParam(value = "Datos de la Historia Clínica", required = true) @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica historiaClinica1 = historyService.crearHistoriaClinica(historiaClinica);
        if (historiaClinica1 == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(historyService.crearHistoriaClinica(historiaClinica));
    }

}

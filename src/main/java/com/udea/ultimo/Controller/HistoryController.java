package com.udea.ultimo.Controller;

import com.udea.ultimo.Config.ApiVersion;
import com.udea.ultimo.Persistance.Model.HistoriaClinica;
import com.udea.ultimo.Service.HistoriaClinica.IHistoriaClinicaService;
import com.udea.ultimo.Service.Medico.IMedicoServicio;
import com.udea.ultimo.Service.Paciente.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(ApiVersion.V1_API + "/history")
public class HistoryController {

    @Autowired
    private IHistoriaClinicaService historyService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IMedicoServicio medicoService;

    @GetMapping(path = "/paciente/{cedula}", produces = "application/json;version=1")
    @Operation(summary = "Obtener Historia Clínica por Cédula de un paciente", responses = {
            @ApiResponse(responseCode = "200", description = "Historia Clínica encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "paciente no encontrado para la cédula proporcionada"),
            @ApiResponse(responseCode = "204", description = "Historia Clínica no encontrada para la cédula proporcionada")
    })

    public ResponseEntity<?> historiaClinica(@PathVariable String cedula) {
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
    @Operation(summary = "Obtener Historia Clínica por Cédula de un médico", responses = {
            @ApiResponse(responseCode = "200", description = "Historia Clínica encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "Medico no encontrado para la cédula proporcionada"),
            @ApiResponse(responseCode = "204", description = "Historia Clínica no encontrada para la cédula proporcionada")
    })
    public ResponseEntity<?> historiaClinicaDoctor(@PathVariable String cedula) {

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
    @Operation(summary = "Ingresar Historia Clínica", responses = {
            @ApiResponse(responseCode = "201", description = "Historia Clínica creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })

    public ResponseEntity<?> ingresarHistoria(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica historiaClinica1 = historyService.crearHistoriaClinica(historiaClinica);
        if (historiaClinica1 == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(historyService.crearHistoriaClinica(historiaClinica));
    }

}

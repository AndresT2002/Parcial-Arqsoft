package com.udea.ultimo.Persistance.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre_paciente")
    private String nombrePaciente;

    @Column(name = "cedula_paciente")
    private String cedulaPaciente;

    @Column(name = "nombre_medico")
    private String nombreMedico;

    @Column(name = "cedula_medico")
    private String cedulaMedico;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;


}

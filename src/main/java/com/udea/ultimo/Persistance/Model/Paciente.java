package com.udea.ultimo.Persistance.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@Table(name = "paciente")
public class Paciente {
    @Id
    @Column(name = "id_paciente")
    private String nombre;
    @Column(name = "nombre")
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private String correo;
    private String fechaNacimiento;
    private String sexo;
}

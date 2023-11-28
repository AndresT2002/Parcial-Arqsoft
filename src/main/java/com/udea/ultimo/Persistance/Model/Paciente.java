package com.udea.ultimo.Persistance.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@Table(name = "paciente")
public class Paciente {
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @NotNull
    @Column(name = "apellido")
    private String apellido;
    @Id
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
}

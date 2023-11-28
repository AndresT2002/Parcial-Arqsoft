package com.udea.ultimo.Persistance.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "apellido")
    @NotNull
    private String apellido;

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

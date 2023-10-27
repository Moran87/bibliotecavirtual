package com.moran.bibliotecavirtual.Objetos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "alumno", schema = "targetSchemaName")

public class Alumno {
    @Id
    @Column(name = "idAlumno", unique = true, nullable = false)
    private String idAlumno;
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;
    @Column(name = "apellidos", unique = false, nullable = false)
    private String apellidos;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CursoCargo_clave", referencedColumnName = "clave", nullable = false)
    private CursoCargo cursoCargo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cuenta_usuario", referencedColumnName = "usuario", nullable = false)
    private Cuenta cuenta;
    
    @OneToOne(mappedBy = "alumno")
    @JsonIgnore
    private Lectura lectura;
    
}

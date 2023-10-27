package com.moran.bibliotecavirtual.Objetos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cuenta", schema = "targetSchemaName")
public class Cuenta {
    @Id
    @Column(name = "usuario",unique = true, nullable = false)
    private String usuario;
    @Column(name = "correo", unique = false, nullable = false)
    private String correo;
    @Column(name = "password", unique = false, nullable = false)
    private String password;
    @OneToOne(mappedBy = "cuenta")
    @JsonIgnore
    private Alumno alumno;
    private Profesor profesor;
}

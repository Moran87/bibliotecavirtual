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
@Table(name = "cursoCargo", schema = "targetSchemaName")

public class CursoCargo {
    @Id
    @Column(name = "clave", unique = true, nullable = false)
    private String clave;
    @Column(name = "cursoCargo", unique = false, nullable = false)
    private String cursoCargo;
    @Column(name = "cicloEscolar", unique = false, nullable = false)
    private String cicloEscolar;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Profesor_idProfesor", referencedColumnName = "idProfesor",nullable = false)
    private Profesor profesor;
    
    @OneToOne(mappedBy = "cursoCargo")
    @JsonIgnore
    private Alumno alumno;
}

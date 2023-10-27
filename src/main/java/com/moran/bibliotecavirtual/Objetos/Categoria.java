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
@Table(name = "categoria", schema = "targetSchemaName")

public class Categoria {
    @Id
    @Column(name = "idCategoria", unique = true, nullable = false)
    private String idCategoria;
    @Column(name = "descripcion", unique = false, nullable = false)
    private String descripcion;
    @OneToOne(mappedBy = "categoria")
    @JsonIgnore
    private Libro libro;
    
}

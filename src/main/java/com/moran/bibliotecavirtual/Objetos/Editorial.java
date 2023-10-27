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
@Table (name = "editorial", schema = "targetSchemaName")
public class Editorial {
    @Id
    @Column(name = "idEditorial", unique = true, nullable = false)
    private String idEditorial;
    @Column(name = "nombreEditorial", unique = true, nullable = false)
    private String nombreEditorial;
    @OneToOne(mappedBy = "editorial")
    @JsonIgnore
    private Libro libro;

}

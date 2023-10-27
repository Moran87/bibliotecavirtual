package com.moran.bibliotecavirtual.Objetos;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "autor", schema = "targetSchemaName")

public class Autor {
    @Id
    @Column(name = "idAutor", unique = true, nullable = false)
    private String idAutor;
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;
    @Column(name = "apellido",unique = false, nullable = false)
    private String apellido;

    @Column(name="libro",nullable = false)
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "Autor_has_Libro", joinColumns = @JoinColumn(name="Autor_idAutor"),inverseJoinColumns = @JoinColumn(name="Libro_idLibro"))
    @JsonIgnore
    Set<Libro>libro;
    
}

package com.moran.bibliotecavirtual.Objetos;

import java.sql.Date;
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
@Table(name = "Lectura", schema = "targetSchemaName")

public class Lectura {
    @Id
    @Column(name = "idLectura", unique = true, nullable = false)
    private String idLectura;
    @Column(name = "fecha", unique = false, nullable = false)
    private Date fecha;
    @Column(name = "observaciones", unique = false, nullable = false)
    private String observaciones;
    @Column(name = "vinculo",unique = false,nullable = false)

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Libro_idLibro", referencedColumnName = "idLibro", nullable = false)
    private Libro libro;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", nullable = false)
    private Alumno alumno;
}

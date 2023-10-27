package com.moran.bibliotecavirtual.Objetos;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "libro", schema = "targetSchemaName")
public class Libro {
    @Id
    @Column(name = "idLibro", unique = true, nullable = false)
    private String idLibro;
    @Column(name = "titulo", unique = false, nullable = false)
    private String titulo;
    @Column(name = "fechaLanzamiento", unique = false, nullable = false)
    private String fechaLanzamineto;
    @Column(name = "idioma", unique = false, nullable = false)
    private String idioma;
    @Column(name = "paginas", unique = false, nullable = false)
    private String paginas;
    @Column(name = "descripcion", unique = false, nullable = false)
    private String descripcion;
    @Column(name = "vinculo", unique = false, nullable = false)
    private String vinculo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Editorial_idEditorial", referencedColumnName = "idEditorial", nullable = false)
    private Editorial editorial;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Categoria_idCategoria", referencedColumnName = "idCategoria", nullable = false)
    private Categoria categoria;

    @OneToOne(mappedBy = "libro")
    @JsonIgnore
    private Lectura lectura;
    @ManyToMany(mappedBy = "libro")
    @JsonIgnore
    Set<Autor> autor;
    
}

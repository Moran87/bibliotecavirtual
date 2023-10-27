package com.moran.bibliotecavirtual.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moran.bibliotecavirtual.Objetos.Libro;

@Repository

public interface LibroRepositorio extends JpaRepository <Libro, String> {
    
}

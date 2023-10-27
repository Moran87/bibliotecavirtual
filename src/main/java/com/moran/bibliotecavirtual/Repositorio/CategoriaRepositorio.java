package com.moran.bibliotecavirtual.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moran.bibliotecavirtual.Objetos.Categoria;

@Repository

public interface CategoriaRepositorio extends JpaRepository <Categoria, String> {
    
}

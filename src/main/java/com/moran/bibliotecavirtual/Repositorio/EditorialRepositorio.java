package com.moran.bibliotecavirtual.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moran.bibliotecavirtual.Objetos.Editorial;

@Repository

public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
    
}

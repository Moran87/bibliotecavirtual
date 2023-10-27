package com.moran.bibliotecavirtual.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moran.bibliotecavirtual.Objetos.CursoCargo;

@Repository

public interface CursoCargoRepositorio extends JpaRepository <CursoCargo, String> {
    
}

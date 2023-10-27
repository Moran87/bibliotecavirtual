package com.moran.bibliotecavirtual.Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.moran.bibliotecavirtual.DTO.AutorDTO;
import com.moran.bibliotecavirtual.Objetos.Autor;

@Repository

public interface AutorRepositorio extends JpaRepository<Autor,String> {
    @Query("SELECT new com.moran.bibliotecavirtual.DTO.AutorDTO(u.idAutor, u.idLibro) FROM Autor u")
    List<AutorDTO> DTOPlay();
    @Procedure(name = "numeroAutor")
    long numeroLibros();
}

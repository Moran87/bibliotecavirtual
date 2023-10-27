package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.DTO.AutorDTO;
import com.moran.bibliotecavirtual.Objetos.Autor;
import com.moran.bibliotecavirtual.Repositorio.AutorRepositorio;
import jakarta.transaction.Transactional;

@Service

public class AutorServicio {
    @Autowired
    AutorRepositorio autorRepositorio;
    Autor autorP=new Autor();
    public Autor registraAutor(Autor autor){
        if(autorRepositorio.existsById(autor.getIdAutor())){
            return autorP;
        }
        else{
            return autorRepositorio.save(autor);
        }
    }
    public Autor modificarAutor(Autor autor){
        if(autorRepositorio.existsById(autor.getIdAutor())){
            return autorRepositorio.save(autor);
        }
        else{
            return autorP;
        }
    }
    public List<Autor>obtenerAutores(){
        return autorRepositorio.findAll();
    }
    public Optional<Autor>obtenerAutorPorId(String idA){
        return autorRepositorio.findById(idA);
    }
    public void eliminarAutor(String idA){
        autorRepositorio.deleteById(idA);
    }
    @Transactional
    public List<AutorDTO>obtenerDTO(){
        return autorRepositorio.DTOPlay();
    }
    public long numeroLibros(){
        return autorRepositorio.numeroLibros();
    }
    
}

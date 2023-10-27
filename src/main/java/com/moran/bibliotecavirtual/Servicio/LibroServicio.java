package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Libro;
import com.moran.bibliotecavirtual.Repositorio.LibroRepositorio;

@Service

public class LibroServicio {
    @Autowired
    LibroRepositorio libroRepositorio;
    Libro libroP = new Libro();
    public Libro registrarLibro(Libro libro){
        if(libroRepositorio.existsById(libro.getIdLibro())){
            return libroP;
        }
        else{
            return libroRepositorio.save(libro);
        }
    }
    public Libro modificarLibro(Libro libro){
        if(libroRepositorio.existsById(libro.getIdLibro())){
            return libroRepositorio.save(libro);
        }
        else{
            return libroP;
        }
    }
    public List<Libro> obtenerLibros(){
        return libroRepositorio.findAll();
    }
    public Optional<Libro> obtenerLibroPorId(String idLi){
        return libroRepositorio.findById(idLi);
    }
    public void eliminarLibro(String idLi){
        libroRepositorio.deleteById(idLi);
    }
}

package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Lectura;
import com.moran.bibliotecavirtual.Repositorio.LecturaRepositorio;

@Service
public class LecturaServicio {
    @Autowired
    LecturaRepositorio lecturaRepositorio;
    Lectura lecturaP = new Lectura();
    public Lectura registrarLectura(Lectura lectura){
        if(lecturaRepositorio.existsById(lectura.getIdLectura())){
            return lecturaP;
        }
        else{
            return lecturaRepositorio.save(lectura);
        }
    }
    public Lectura modificarLectura(Lectura lectura){
        if(lecturaRepositorio.existsById(lectura.getIdLectura())){
            return lecturaRepositorio.save(lectura);
        }
        else{
            return lecturaP;
        }
    }
    public List<Lectura> obtenerLecturas(){
        return lecturaRepositorio.findAll();
    }
    public Optional<Lectura> obtenerLecturaPorId (String idle){
        return lecturaRepositorio.findById(idle);
    }
    public void eliminarLectura(String idle){
        lecturaRepositorio.deleteById(idle);
    }
    
}

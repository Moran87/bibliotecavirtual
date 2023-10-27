package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Profesor;
import com.moran.bibliotecavirtual.Repositorio.ProfesorRepositorio;

@Service
public class ProfesorServicio {
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    Profesor profesorP = new Profesor();
    public Profesor registrarProfesor(Profesor profesor){
        if(profesorRepositorio.existsById(profesor.getIdProfesor())){
            return profesorP;
        }
        else{
            return profesorRepositorio.save(profesor);
        }
    }
    public Profesor modificarProfesor(Profesor profesor){
        if(profesorRepositorio.existsById(profesor.getIdProfesor())){
            return profesorRepositorio.save(profesor);
        }
        else{
            return profesorP;
        }
    }
    public List<Profesor> obtenerProfesores(){
        return profesorRepositorio.findAll();
    }
    public Optional<Profesor> obtenerProfesorPorId(String idP){
        return profesorRepositorio.findById(idP);
    }
    public void eliminarProfesor(String idP){
        profesorRepositorio.deleteById(idP);
    }
    
}

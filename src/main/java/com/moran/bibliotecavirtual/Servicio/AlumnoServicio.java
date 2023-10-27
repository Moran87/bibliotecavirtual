package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Alumno;
import com.moran.bibliotecavirtual.Repositorio.AlumnoRepositorio;

@Service
public class AlumnoServicio {
    @Autowired
    AlumnoRepositorio alumnoRepositorio;
    Alumno alumnoP = new Alumno();
    public Alumno registrarAlumno(Alumno alumno){
        if(alumnoRepositorio.existsById(alumno.getIdAlumno())){
            return alumnoP;
        }
        else{
            return alumnoRepositorio.save(alumno);
        }
    }
    public Alumno modificarAlumno(Alumno alumno){
        if(alumnoRepositorio.existsById(alumno.getIdAlumno())){
            return alumnoRepositorio.save(alumno);
        }
        else{
            return alumnoP;
        }
    }
    public List<Alumno> obtenerAlumnos(){
        return alumnoRepositorio.findAll();
    }
    public Optional<Alumno> obtenerAlumnoPorId(String idAl){
        return alumnoRepositorio.findById(idAl);
    }
    public void eliminarAlumno(String idAl){
        alumnoRepositorio.deleteById(idAl);
    }
}

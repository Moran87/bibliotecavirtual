package com.moran.bibliotecavirtual.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moran.bibliotecavirtual.Objetos.Alumno;
import com.moran.bibliotecavirtual.Servicio.AlumnoServicio;

@RestController
@RequestMapping("/Alumno")
public class AlumnoControlador {
    @Autowired
    AlumnoServicio alumnoServicio;
    @PostMapping("/registrarAlumno")
    public Alumno registrarAlumno(@RequestBody Alumno alumno){
        return alumnoServicio.registrarAlumno(alumno);
    }
    @PutMapping("/modificarAlumno")
    public Alumno modificarAlumno(@RequestBody Alumno alumno){
        return alumnoServicio.modificarAlumno(alumno);
    }
    @GetMapping("/obtenerAlumnos")
    public List<Alumno> obtenerAlumnos(){
        return alumnoServicio.obtenerAlumnos();
    }
    @GetMapping("/obtenerAlumnoPorId")
    public Optional<Alumno> obtenerAlumnoPorId(@RequestParam String idA){
        return alumnoServicio.obtenerAlumnoPorId(idA);
    }
    @DeleteMapping("/eliminarAlumno")
    public void eliminarAlumno(@RequestParam String idA){
        alumnoServicio.eliminarAlumno(idA);
    }
}

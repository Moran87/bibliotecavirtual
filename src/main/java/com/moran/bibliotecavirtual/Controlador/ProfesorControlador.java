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
import com.moran.bibliotecavirtual.Objetos.Profesor;
import com.moran.bibliotecavirtual.Servicio.ProfesorServicio;

@RestController
@RequestMapping("/profesor")

public class ProfesorControlador {
    @Autowired
    ProfesorServicio profesorServicio;
    @PostMapping("/registrarProfesor")
    public Profesor registProfesor(@RequestBody Profesor profesor){
        return profesorServicio.registrarProfesor(profesor);
    }
    @PutMapping("/modificarProfesor")
    public Profesor modificarProfesor(@RequestBody Profesor profesor){
        return profesorServicio.modificarProfesor(profesor);
    }
    @GetMapping("/obtenerProfesores")
    public List<Profesor> obtenerProfesores(){
        return profesorServicio.obtenerProfesores();
    }
    @GetMapping("/obtenerProfesorPorId")
    public Optional<Profesor> obtenerProfesorPorId(@RequestParam String idP){
        return profesorServicio.obtenerProfesorPorId(idP);
    }
    @DeleteMapping("/eliminarProfesor")
    public void eliminarProfesor(@RequestParam String idP){
        profesorServicio.eliminarProfesor(idP);
    }
}

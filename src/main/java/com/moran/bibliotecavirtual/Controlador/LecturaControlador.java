package com.moran.bibliotecavirtual.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.moran.bibliotecavirtual.Objetos.Lectura;
import com.moran.bibliotecavirtual.Servicio.LecturaServicio;

@Controller
@RequestMapping("/Lectura")
public class LecturaControlador {
    @Autowired
    LecturaServicio lecturaServicio;
    @PostMapping("/registrarLectura")
    public Lectura registrarLectura(@RequestBody Lectura lectura){
        return lecturaServicio.registrarLectura(lectura);
    }
    @PutMapping("/modificarLectura")
    public Lectura modificarLectura(@RequestBody Lectura lectura){
        return lecturaServicio.modificarLectura(lectura);
    }
    @GetMapping("/obtenerLecturas")
    public List<Lectura> obtenerLecturas(){
        return lecturaServicio.obtenerLecturas();
    }
    @GetMapping("/obternerLecturaPorId")
    public Optional<Lectura> obternerLecturaPorId(@RequestParam String idLe){
        return lecturaServicio.obtenerLecturaPorId(idLe);
    }
    @DeleteMapping("/eleminarLectura")
    public void eliminarLectura(@RequestParam String idLe){
        lecturaServicio.eliminarLectura(idLe);
    }
}

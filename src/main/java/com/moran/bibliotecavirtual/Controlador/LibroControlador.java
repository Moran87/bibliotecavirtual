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
import com.moran.bibliotecavirtual.Objetos.Libro;
import com.moran.bibliotecavirtual.Servicio.LibroServicio;

@RestController
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    LibroServicio libroServicio;
    @PostMapping("/registrarLibro")
    public Libro registrarLibro(@RequestBody Libro libro){
        return libroServicio.registrarLibro(libro);
    }
    @PutMapping("/moodificarLibro")
    public Libro modificarLibro(@RequestBody Libro libro){
        return libroServicio.modificarLibro(libro);
    }
    @GetMapping("/obtenerLibros")
    public List<Libro> obtenerLibros(){
        return libroServicio.obtenerLibros();
    }
    @GetMapping("/obtenerLibroPorId")
    public Optional<Libro> obtenerLibroPorId(@RequestParam String idLi){
        return libroServicio.obtenerLibroPorId(idLi);
    }
    @DeleteMapping("/eliminarLibro")
    public void eliminarLibro(@RequestParam String idLi){
        libroServicio.eliminarLibro(idLi);
    }
}

package com.moran.bibliotecavirtual.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moran.bibliotecavirtual.DTO.AutorDTO;
import com.moran.bibliotecavirtual.Objetos.Autor;
import com.moran.bibliotecavirtual.Servicio.AutorServicio;

@RestController
@RequestMapping("/autor")
public class AutorControlador {
    @Autowired
    AutorServicio autorServicio;
    @PostMapping("/registrarAutor")
    public Autor registrarAutor(@RequestBody Autor autor){
        return autorServicio.registraAutor(autor);
    }
    @GetMapping("/obtenerAutores")
    public List<Autor> obtenerAutores(){
        return autorServicio.obtenerAutores();
    }
    @GetMapping("/obtenerAutorPorId")
    public Optional<Autor> obtenerAutorPorId(@RequestParam String idAu){
        return autorServicio.obtenerAutorPorId(idAu);
    }
    @DeleteMapping("/eliminarAutor")
    public void eliminarAutor(@RequestParam String idAu){
        autorServicio.eliminarAutor(idAu);
    }

    @CrossOrigin
    @PutMapping(value="/modificarAutor",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Autor modificarAutor(@ModelAttribute Autor autor){
        return autorServicio.modificarAutor(autor);
    }
    @GetMapping("/obtenerDTO")
    public List<AutorDTO> obtener(){
        return autorServicio.obtenerDTO();
    }
    @GetMapping("autores")
    public Long numeroLibros(){
        return autorServicio.numeroLibros();
    }
}

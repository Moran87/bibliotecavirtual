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
import com.moran.bibliotecavirtual.Objetos.Editorial;
import com.moran.bibliotecavirtual.Servicio.EditorialServicio;

@RestController
@RequestMapping("/Editorial")
public class EditorialControlador {
    @Autowired
    EditorialServicio editorialServicio;
    @PostMapping("/registrarEditorial")
    public Editorial registrarEditorial(@RequestBody Editorial editorial){
        return editorialServicio.registrarEditorial(editorial);
    }
    @PutMapping("/modificarEditorial")
    public Editorial modificarEditorial(@RequestBody Editorial editorial){
        return editorialServicio.modificarEditorial(editorial);
    }
    @GetMapping("/obtenerEditoriales")
    public List<Editorial> obtenerEditoriales(){
        return editorialServicio.obtenerEditoriales();
    }
    @GetMapping("/obtenerEditorialPorId")
    public Optional<Editorial> obtenerEditorialPorId(@RequestParam String idEd){
        return editorialServicio.obtenerEditorialPorIdEditorial(idEd);
    }
    @DeleteMapping("/eliminarEditorial")
    public void eliminarEditorial(@RequestParam String idEd){
        editorialServicio.eliminarEditorial(idEd);
    }
}

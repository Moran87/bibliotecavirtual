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
import com.moran.bibliotecavirtual.Objetos.Categoria;
import com.moran.bibliotecavirtual.Servicio.CategoriaServicio;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
    @Autowired
    CategoriaServicio categoriaServicio;
    @PostMapping("/registrarCategoria")
    public Categoria registrarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.registrarCategoria(categoria);
    }
    @PutMapping("/modificarCategoria")
    public Categoria modificarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.modificarCategoria(categoria);
    }
    @GetMapping("/obtenerCategorias")
    public List<Categoria>obtenerCategorias(){
        return categoriaServicio.obtenerCategorias();
    }
    @GetMapping("/obtenerCategoriaPorId")
    public Optional<Categoria> obtenerCategoriaPorId(@RequestParam String idCa){
        return categoriaServicio.obtenerCategoriaPorIdC(idCa);
    }
    @DeleteMapping("/eliminarCategoria")
    public void eliminarCategoria(@RequestParam String idCa){
        categoriaServicio.eliminarCategoria(idCa);
    }
}

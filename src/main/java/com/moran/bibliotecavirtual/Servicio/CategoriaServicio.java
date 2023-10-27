package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Categoria;
import com.moran.bibliotecavirtual.Repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicio {
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    Categoria categoriaP = new Categoria();
    public Categoria registrarCategoria(Categoria categoria){
        if(categoriaRepositorio.existsById(categoria.getIdCategoria())){
            return categoriaP;
        }
        else{
            return categoriaRepositorio.save(categoria);
        }
    }
    public Categoria modificarCategoria(Categoria categoria){
        if(categoriaRepositorio.existsById(categoria.getIdCategoria())){
            return categoriaRepositorio.save(categoria);
        }
        else{
            return categoriaP;
        }
    }
    public List<Categoria> obtenerCategorias(){
        return categoriaRepositorio.findAll();
    }
    public Optional<Categoria> obtenerCategoriaPorIdC(String idC){
        return categoriaRepositorio.findById(idC);
    }
    public void eliminarCategoria(String idC){
        categoriaRepositorio.deleteById(idC);
    }
}

package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.Editorial;
import com.moran.bibliotecavirtual.Repositorio.EditorialRepositorio;

@Service

public class EditorialServicio {
    @Autowired
    EditorialRepositorio editorialRepositorio;
    Editorial editorialP=new Editorial();
    public Editorial registrarEditorial(Editorial editorial){
        if(editorialRepositorio.existsById(editorial.getIdEditorial())){
            return editorialP;
        }
        else{
            return editorialRepositorio.save(editorial);
        }
    }
    public Editorial modificarEditorial(Editorial editorial){
        if(editorialRepositorio.existsById(editorial.getIdEditorial())){
            return editorialRepositorio.save(editorial);
        }
        else{
            return editorialP;
        }
    }
    public List<Editorial> obtenerEditoriales(){
        return editorialRepositorio.findAll();
    }
    public Optional<Editorial> obtenerEditorialPorIdEditorial(String idE){
        return editorialRepositorio.findById(idE);
    }
    public void eliminarEditorial(String idE){
        editorialRepositorio.deleteById(idE);
    }
}

package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moran.bibliotecavirtual.Objetos.CursoCargo;
import com.moran.bibliotecavirtual.Repositorio.CursoCargoRepositorio;

@Service
public class CursoCargoServicio {
    @Autowired
    CursoCargoRepositorio cursoCargoRepositorio;
    CursoCargo cursoCargoP = new CursoCargo();
    public CursoCargo registrarCursoCargo(CursoCargo cursoCargo){
        if(cursoCargoRepositorio.existsById(cursoCargo.getClave())){
            return cursoCargoP;
        }
        else{
            return cursoCargoRepositorio.save(cursoCargo);
        }
    }
    public CursoCargo modificaCursoCargo(CursoCargo cursoCargo){
        if(cursoCargoRepositorio.existsById(cursoCargo.getClave())){
            return cursoCargoRepositorio.save(cursoCargo);
        }
        else{
            return cursoCargoP;
        }
    }
    public List<CursoCargo> obtenerCursoCargos(){
        return cursoCargoRepositorio.findAll();
    }
    public Optional<CursoCargo> obtenerCursoCargoPorClave(String clave){
        return cursoCargoRepositorio.findById(clave);
    }
    public void eliminarCursoCargo(String clave){
        cursoCargoRepositorio.deleteById(clave);
    }
}

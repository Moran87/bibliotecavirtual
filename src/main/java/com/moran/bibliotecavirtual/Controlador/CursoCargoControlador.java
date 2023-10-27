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
import com.moran.bibliotecavirtual.Objetos.CursoCargo;
import com.moran.bibliotecavirtual.Servicio.CursoCargoServicio;

@RestController
@RequestMapping("/cursoCargo")

public class CursoCargoControlador {
    @Autowired
    CursoCargoServicio cursoCargoServicio;
    @PostMapping("/registrarCursoCargo")
    public CursoCargo registrarCursoCargo(@RequestBody CursoCargo cursoCargo){
        return cursoCargoServicio.registrarCursoCargo(cursoCargo);
    }
    @PutMapping("/modificarCursoCargo")
    public CursoCargo modificarCursoCargo(@RequestBody CursoCargo cursoCargo){
        return cursoCargoServicio.modificaCursoCargo(cursoCargo);
    }
    @GetMapping("/obtenerCursoCargos")
    public List<CursoCargo> obtenerCursoCargos(){
        return cursoCargoServicio.obtenerCursoCargos();
    }
    @GetMapping("/obtenerCursoCargoPorClave")
    public Optional<CursoCargo> obtenerCursoCargoPorClave(@RequestParam String Clave){
        return cursoCargoServicio.obtenerCursoCargoPorClave(Clave);
    }
    @DeleteMapping("/eliminarCursoCargo")
    public void eliminarCursoCargo(@RequestParam String clave){
        cursoCargoServicio.eliminarCursoCargo(clave);
    }
}

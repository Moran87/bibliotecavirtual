package com.moran.bibliotecavirtual.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moran.bibliotecavirtual.Repositorio.CuentaRepositorio;
import com.moran.bibliotecavirtual.Objetos.Cuenta;

@Service
public class CuentaServicio {
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    Cuenta cuentaP=new Cuenta();
    public Cuenta registrarCuenta(Cuenta cuenta){
        if(cuentaRepositorio.existsById(cuenta.getUsuario())){
            return cuentaP;
        }
        else{
            return cuentaRepositorio.save(cuenta);
        }
    }
    public Cuenta modificarCuenta(Cuenta cuenta){
        if(cuentaRepositorio.existsById(cuenta.getUsuario())){
            return cuentaRepositorio.save(cuenta);
        }
        else{
            return cuentaP;
        }
    }
    public List<Cuenta>obtenerCuentas(){
        return cuentaRepositorio.findAll();
    }
    public Optional<Cuenta> obtenerCuentaPorNombre(String nombre){
        return cuentaRepositorio.findById(nombre);
    }
    public void eliminarCuenta(String nombre){
        cuentaRepositorio.deleteById(nombre);
    }
}

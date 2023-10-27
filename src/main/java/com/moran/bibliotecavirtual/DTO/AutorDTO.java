package com.moran.bibliotecavirtual.DTO;

public class AutorDTO {
    private String idAutor;
    private String idLibro;
    public AutorDTO(String idAutor, String idLibro){
        super();
        this.idAutor=idAutor;
        this.idLibro=idLibro;
    }
    public AutorDTO(){

    }
    public String getIdAutor(){
        return idAutor;
    }
    public void setIdAutor(String idAutor){
        this.idAutor=idAutor;
    }
    public String getIdLibro(){
        return idLibro;
    }
    public void setIdLibro(String idLibro){
        this.idLibro=idLibro;
    }
}

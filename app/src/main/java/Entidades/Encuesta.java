package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Encuesta implements Serializable {

    private String genero;
    private String edad;
    private String Comida;
    private String Ubicacion;
    private String Categoria;


    public Encuesta(){
        this.genero="";
        this.edad="";
        this.Ubicacion="";
        this.Categoria="";
        this.Comida="";
    }

    public Encuesta(String gene,String edad,String ubicacion){
        this.genero=gene;
        this.edad=edad;
        this.Ubicacion=ubicacion;
    }

    public Encuesta(String gene,String edad,ArrayList comidasSeleccionado,String ubicacion){
        this.genero=gene;
        this.edad=edad;
        this.Ubicacion=ubicacion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getComida() {
        return Comida;
    }

    public void setComida(String comida) {
        Comida = comida;
    }

}

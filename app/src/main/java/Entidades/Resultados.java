package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Resultados {

    public String categoria;
    public String Platillo;
    public int cantidadUsuarios;
    public List<String>EdadesUsuarios;
    public List<String>Lugares;
    private int cM,cF,cO;

    public Resultados(){
        categoria="";
        Platillo="";
        cantidadUsuarios=0;
        EdadesUsuarios=new ArrayList<String>();
        Lugares=new ArrayList<String>();
        this.cM=0;
        this.cF=0;
        this.cO=0;
    }

    public Resultados(String Categoria, String Plato){
        this.categoria=Categoria;
        this.Platillo=Plato;
        cantidadUsuarios=0;
        EdadesUsuarios=new ArrayList<String>();
        Lugares=new ArrayList<String>();
        this.cM=0;
        this.cF=0;
        this.cO=0;
    }

    public List<String> getLugares() {
        return Lugares;
    }

    public int getcM() {
        return cM;
    }

    public int getcF() {
        return cF;
    }

    public int getcO() {
        return cO;
    }

    public void setLugares(List<String> lugares) {
        Lugares = lugares;
    }

    public String getCategoria() {
        return categoria;
    }

    public void SetGenerosParaConteo(String genero){
        switch (genero){
            case "Femenino":{
                this.cF++;
            }break;
            case "Masculino":{
                this.cM++;
            }break;
            case "Otro/s":{
                this.cO++;
            }break;
            default:
                this.cM++;
                break;
        }
    }

    public String DevolverLugares(){
        String resultado="";
            for(int i=0;i<Lugares.size();i++){
                resultado+=(Lugares.get(i)+",");
            }
//            resultado=resultado.substring(0,resultado.length()-1);
        return resultado;
    }

    public void AgregarLugar(String lugar){
        try {
            if(this.Lugares.indexOf(lugar)>1){
                Lugares.add(lugar);
            }
        }catch (Exception e){
        }
    }

    public void AgregarEdadAlaLista(String edad){
        try {
            if(this.EdadesUsuarios.indexOf(edad)>-1){
                EdadesUsuarios.add(edad);
            }
        }catch (Exception e){
        }
    }

    public void AumentarCantidadUsuarioEnUno(){
        this.cantidadUsuarios++;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlatillo() {
        return Platillo;
    }

    public void setPlatillo(String platillo) {
        Platillo = platillo;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuarios(int cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public List<String> getEdadesUsuarios() {
        return EdadesUsuarios;
    }

    public void setEdadesUsuarios(List<String> edadesUsuarios) {
        EdadesUsuarios = edadesUsuarios;
    }
}

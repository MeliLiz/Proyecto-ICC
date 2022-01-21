import java.io.Serializable;

import java.io.Serializable;
public class Jugador implements Serializable{
    protected String nombre;
    //protected int vecesGanadas;
    protected boolean gana;

    public Jugador (){
        nombre = "Unknown";
        gana = false;
        //vecesGanadas
    }

    public Jugador(String nombre){
        this.nombre=nombre;
        gana = false;
    }

    public void gana(){
        gana=true;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setGana(boolean gana){
        this.gana=gana;
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean getGana(){
        return this.gana;
    }

    public boolean equals(Object obj){
        Jugador jug = (Jugador)obj;
        if(nombre.equals(jug.nombre)){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return "Jugador(a) " + nombre;
    }
}
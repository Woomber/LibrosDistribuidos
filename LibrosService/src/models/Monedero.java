package models;

import java.io.Serializable;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class Monedero implements Serializable {
    private final int id;
    private int idUsuario;
    private String dinero;

    public Monedero(){
        id = 0;
    }
    
    public Monedero(int id){
        this.id = id;
    }

    public Monedero(int id, int idUsuario, String dinero) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dinero = dinero;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDinero() {
        return dinero;
    }

    public void setDinero(String dinero) {
        this.dinero = dinero;
    }

   
    
}

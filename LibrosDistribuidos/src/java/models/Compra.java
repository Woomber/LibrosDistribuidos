package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class Compra implements Serializable {
    private final int id;
    private Date fecha;
    private int idPublicacion;
    private int idUsuario;

    public Compra() {
        this.id = 0;
    }

    public Compra(int id) {
        this.id = id;
    }

    public Compra(int id, Date fecha, int idPublicacion, int idUsuario) {
        this.id = id;
        this.fecha = fecha;
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}

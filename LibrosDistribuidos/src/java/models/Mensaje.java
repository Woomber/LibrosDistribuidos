package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class Mensaje implements Serializable {
    private final int id;
    private String mensaje;
    private Date fecha;
    private int idUsuario;
    private int idForo;

    public Mensaje() {
        this.id = 0;
    }

    public Mensaje(int id) {
        this.id = id;
    }

    public Mensaje(int id, String mensaje, Date fecha, int id_usuario, int id_foro) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.idUsuario = id_usuario;
        this.idForo = id_foro;
    }

    public int getId() {
        return id;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }
    
    
}

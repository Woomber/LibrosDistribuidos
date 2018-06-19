package models;

import java.util.Date;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class Publicacion {
    private final int id;
    private String texto;
    private Date fecha;
    private boolean estado;
    private double precio;
    private int idUsuario;

    public Publicacion() {
        this.id = 0;
    }

    public Publicacion(int id) {
        this.id = id;
    }

    public Publicacion(int id, String texto, Date fecha, boolean estado, double precio, int idUsuario) {
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}

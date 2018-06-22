/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import models.*;

/**
 *
 * @author Maritza
 */
public interface PublicacionInterfaz extends Remote {
    
    public ArrayList<Publicacion> get() throws RemoteException;
    public Publicacion getById(int id) throws RemoteException;
    public int insert(Publicacion item) throws RemoteException;
    public int updateEstado(int id, boolean estado) throws RemoteException;
    public ArrayList<Publicacion> search(String consulta) throws RemoteException;
}

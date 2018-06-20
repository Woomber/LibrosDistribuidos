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
public interface UsuarioInterfaz extends Remote {
    
    public ArrayList<Usuario> get() throws RemoteException;
    public Usuario getById(int id) throws RemoteException;
    public Usuario login(String username, String password) throws RemoteException;
    public int insert(Usuario item) throws RemoteException;
    
}

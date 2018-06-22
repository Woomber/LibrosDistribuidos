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
public interface MonederoInterfaz extends Remote {
    
    public Monedero getByUsuario(int idUsuario) throws RemoteException;
    public int insert(Monedero item) throws RemoteException;
    public int updateDinero(int idUsuario, String dinero) throws RemoteException;
    
}

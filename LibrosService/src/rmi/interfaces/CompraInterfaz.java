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
public interface CompraInterfaz extends Remote {
    
    public ArrayList<Compra> get() throws RemoteException;
    public Compra getById(int id) throws RemoteException;
    public int insert(Compra item) throws RemoteException;
    public int delete(int id) throws RemoteException;
    
}

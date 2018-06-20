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
public interface ForoInterfaz extends Remote {
    
    public ArrayList<Foro> get() throws RemoteException;
    public int insert() throws RemoteException;
    
}

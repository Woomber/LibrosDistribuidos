/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.objetos;

import java.util.ArrayList;
import models.Compra;
import rmi.interfaces.*;
import controllers.*;
import java.rmi.RemoteException;

/**
 *
 * @author Maritza
 */
public class CompraRMI implements CompraInterfaz {
    
    private final CompraController controller;
    
    public CompraRMI(){
        controller = new CompraController();
    }

    @Override
    public ArrayList<Compra> get() throws RemoteException {
        return controller.get();
    }

    @Override
    public Compra getById(int id) throws RemoteException {
       return controller.getById(id);
    }

    @Override
    public int insert(Compra item) throws RemoteException {
        return controller.insert(item);
    }

    @Override
    public int delete(int id) throws RemoteException {
        return controller.delete(id);
    }
    
}

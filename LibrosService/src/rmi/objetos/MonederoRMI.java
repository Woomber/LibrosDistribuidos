/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.objetos;

import java.util.ArrayList;
import models.*;
import rmi.interfaces.*;
import controllers.*;
import java.rmi.RemoteException;

/**
 *
 * @author Maritza
 */
public class MonederoRMI implements MonederoInterfaz {
    
    private final MonederoController controller;
    
    public MonederoRMI(){
        controller = new MonederoController();
    }

    @Override
    public Monedero getByUsuario(int idUsuario) throws RemoteException {
        return controller.getByUsuario(idUsuario);
    }

    @Override
    public int insert(Monedero item) throws RemoteException {
        return controller.insert(item);
    }

    @Override
    public int updateDinero(int idUsuario, String dinero) throws RemoteException {
        return controller.updateDinero(idUsuario, dinero);
    }


    
}

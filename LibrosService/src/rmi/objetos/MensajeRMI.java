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
public class MensajeRMI implements MensajeInterfaz {
    
    private final MensajeController controller;
    
    public MensajeRMI(){
        controller = new MensajeController();
    }

    @Override
    public ArrayList<Mensaje> get() throws RemoteException {
        return controller.get();
    }

    @Override
    public Mensaje getById(int id) throws RemoteException {
        return controller.getById(id);
    }

    @Override
    public int insert(Mensaje item) throws RemoteException {
        return controller.insert(item);
    }


    
}

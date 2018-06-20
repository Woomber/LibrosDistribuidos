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
import models.Foro;

/**
 *
 * @author Maritza
 */
public class ForoRMI implements ForoInterfaz {
    
    private final ForoController controller;
    
    public ForoRMI(){
        controller = new ForoController();
    }

    @Override
    public ArrayList<Foro> get() throws RemoteException {
       return controller.get();
    }

    @Override
    public int insert() throws RemoteException {
       return controller.insert();
    }

    
    
}

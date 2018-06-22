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
public class PublicacionRMI implements PublicacionInterfaz {
    
    private final PublicacionController controller;
    
    public PublicacionRMI(){
        controller = new PublicacionController();
    }

    @Override
    public ArrayList<Publicacion> get() throws RemoteException {
        return controller.get();
    }

    @Override
    public Publicacion getById(int id) throws RemoteException {
        return controller.getById(id);
    }

    @Override
    public int insert(Publicacion item) throws RemoteException {
        return controller.insert(item);
    }

    @Override
    public int updateEstado(int id, boolean estado) throws RemoteException {
        return controller.updateEstado(id, estado);
    }

    @Override
    public ArrayList<Publicacion> search(String consulta) throws RemoteException {
        return controller.search(consulta);
    }

   

 
}

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
public class UsuarioRMI implements UsuarioInterfaz {
    
    private final UsuarioController controller;
    
    public UsuarioRMI(){
        controller = new UsuarioController();
    }

    @Override
    public ArrayList<Usuario> get() throws RemoteException {
        return controller.get();
    }

    @Override
    public Usuario getById(int id) throws RemoteException {
        return controller.getById(id);
    }

    @Override
    public Usuario login(String username, String password) throws RemoteException {
        return controller.login(username, password);
    }

    @Override
    public int insert(Usuario item) throws RemoteException {
        return controller.insert(item);
    }    
    
}

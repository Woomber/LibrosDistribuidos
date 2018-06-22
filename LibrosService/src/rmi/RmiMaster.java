/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.interfaces.*;
import rmi.objetos.*;

/**
 *
 * @author Maritza
 */
public class RmiMaster {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        System.setProperty("java.rmi.server.hostname", "localhost");
        
        CompraInterfaz compra = (CompraInterfaz)
                UnicastRemoteObject.exportObject(new CompraRMI(), 0);
        ForoInterfaz foro = (ForoInterfaz)
                UnicastRemoteObject.exportObject(new ForoRMI(), 0);
        MensajeInterfaz mensaje = (MensajeInterfaz)
                UnicastRemoteObject.exportObject(new MensajeRMI(), 0);
        PublicacionInterfaz publicacion = (PublicacionInterfaz)
                UnicastRemoteObject.exportObject(new PublicacionRMI(), 0);
        UsuarioInterfaz usuario = (UsuarioInterfaz)
                UnicastRemoteObject.exportObject(new UsuarioRMI(), 0);
        MonederoInterfaz monedero = (MonederoInterfaz)
                UnicastRemoteObject.exportObject(new MonederoRMI(), 0);
        
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();

        registry.bind("Compra", compra);
        registry.bind("Foro", foro);     
        registry.bind("Mensaje", mensaje);
        registry.bind("Publicacion", publicacion);
        registry.bind("Usuario", usuario);
        registry.bind("Monedero", monedero);

        System.out.println("Servidor listo :)");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.interfaces.*;

/**
 *
 * @author Maritza
 */
public class RmiClient {
    
    public  CompraInterfaz compras;
    public  ForoInterfaz foros;
    public  MensajeInterfaz mensajes;
    public  PublicacionInterfaz publicaciones;
    public  UsuarioInterfaz usuarios;
    
    public RmiClient(){
          try {
            Registry registry = LocateRegistry.getRegistry("localhost");

            compras = (CompraInterfaz) registry.lookup("Compra");
            foros = (ForoInterfaz) registry.lookup("Foro");
            mensajes = (MensajeInterfaz) registry.lookup("Mensaje");
            publicaciones = (PublicacionInterfaz) registry.lookup("Publicacion");
            usuarios = (UsuarioInterfaz) registry.lookup("Usuario");

          } catch(RemoteException | NotBoundException ex){
              System.out.println(ex.getMessage());
          }
    }

    
}

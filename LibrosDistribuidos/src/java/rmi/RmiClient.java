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
    
    public  CompraInterfaz compra;
    public  ForoInterfaz foro;
    public  MensajeInterfaz mensaje;
    public  PublicacionInterfaz publicacion;
    public  UsuarioInterfaz usuario;
    
    public RmiClient(){
          try {
            Registry registry = LocateRegistry.getRegistry("localhost");

            compra = (CompraInterfaz) registry.lookup("Compra");
            foro = (ForoInterfaz) registry.lookup("Foro");
            mensaje = (MensajeInterfaz) registry.lookup("Mensaje");
            publicacion = (PublicacionInterfaz) registry.lookup("Publicacion");
            usuario = (UsuarioInterfaz) registry.lookup("Usuario");

          } catch(RemoteException | NotBoundException ex){
              System.out.println(ex.getMessage());
          }
    }

    
}

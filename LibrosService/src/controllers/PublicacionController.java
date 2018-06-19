package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import models.Publicacion;
import models.Usuario;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class PublicacionController extends Controller {
    
    private static final String BD_TABLE = "publicacion";

    public ArrayList<Publicacion> get(){
        final String QUERY = "SELECT * FROM " + BD_TABLE;
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            ResultSet rs = query.executeQuery();
            
            ArrayList<Publicacion> resultados = new ArrayList<>();
            
            while(rs.next()){
                Publicacion item = new Publicacion(
                        rs.getInt("id"),
                        rs.getString("texto"),
                        rs.getDate("fecha"),
                        rs.getBoolean("estado"),
                        rs.getDouble("precio"),
                        rs.getInt("id_usuario")
                );
                
                resultados.add(item);
            }
            return resultados;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public Publicacion getById(int id){
        final String QUERY = "SELECT * FROM " + BD_TABLE + " WHERE id = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
          
            if(rs.next()){
                Publicacion item = new Publicacion(
                        rs.getInt("id"),
                        rs.getString("texto"),
                        rs.getDate("fecha"),
                        rs.getBoolean("estado"),
                        rs.getDouble("precio"),
                        rs.getInt("id_usuario")
                );
                
                return item;
            }
            return null;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int insert(Publicacion item){
         final String QUERY = "INSERT INTO " + BD_TABLE 
                 + " (texto, fecha, estado, id_usuario, precio) "
                 + " VALUES (?, NOW(), ?, ?, ?)";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, item.getTexto());
            query.setBoolean(2, item.isEstado());
            query.setInt(3, item.getIdUsuario());
            query.setDouble(4, item.getPrecio());
            query.executeUpdate();
          
            ResultSet keys = query.getGeneratedKeys();
            if(keys.next()){
                return keys.getInt(1);
            }      
            return 0;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int updateEstado(int id, boolean estado){
        final String QUERY = "UPDATE" + BD_TABLE 
                 + " SET estado = ? "
                 + " WHERE id = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setBoolean(1, estado);
            query.setInt(2, id);
            
            return query.executeUpdate();
        
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}

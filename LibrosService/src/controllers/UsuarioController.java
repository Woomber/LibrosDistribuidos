package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Usuario;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class UsuarioController extends Controller {
    
    private static final String BD_TABLE = "usuario";

    public ArrayList<Usuario> get(){
        final String QUERY = "SELECT * FROM " + BD_TABLE;
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            ResultSet rs = query.executeQuery();
            
            ArrayList<Usuario> resultados = new ArrayList<>();
            
            while(rs.next()){
                Usuario item = new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("hash")
                );
                
                resultados.add(item);
            }
            return resultados;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public Usuario getById(int id){
        final String QUERY = "SELECT * FROM " + BD_TABLE + " WHERE id = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
          
            if(rs.next()){
                Usuario item = new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("hash")
                );
                
                return item;
            }
            return null;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int insert(Usuario item){
         final String QUERY = "INSERT INTO " + BD_TABLE 
                 + " (username, password, nombre, apellidos) "
                 + " VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, item.getUsername());
            query.setString(2, item.getPassword());
            query.setString(3, item.getNombre());
            query.setString(4, item.getApellidos());
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
}

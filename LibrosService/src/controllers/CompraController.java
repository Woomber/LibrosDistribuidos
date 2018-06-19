package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Compra;
import models.Usuario;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class CompraController extends Controller {
    
    private static final String BD_TABLE = "compra";

    public ArrayList<Compra> get(){
        final String QUERY = "SELECT * FROM " + BD_TABLE;
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            ResultSet rs = query.executeQuery();
            
            ArrayList<Compra> resultados = new ArrayList<>();
            
            while(rs.next()){
                Compra item = new Compra(
                        rs.getInt("id"),
                        rs.getDate("fecha"),
                        rs.getInt("id_publicacion"),
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
    
    public Compra getById(int id){
        final String QUERY = "SELECT * FROM " + BD_TABLE + " WHERE id = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
          
            if(rs.next()){
                Compra item = new Compra(
                        rs.getInt("id"),
                        rs.getDate("fecha"),
                        rs.getInt("id_publicacion"),
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
    
    public int insert(Compra item){
         final String QUERY = "INSERT INTO " + BD_TABLE 
                 + " (fecha, id_publicacion, id_usuario) "
                 + " VALUES (NOW(), ?, ?)";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, item.getIdPublicacion());
            query.setInt(2, item.getIdUsuario());

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
    
        
    public int delete(int id){
         final String QUERY = "DELETE FROM " + BD_TABLE 
                 + " WHERE id = ? ";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, id);

            return query.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}

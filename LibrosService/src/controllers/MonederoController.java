package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Monedero;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class MonederoController extends Controller {
    
    private static final String BD_TABLE = "monedero";
 
    public Monedero getByUsuario(int idUsuario){
        final String QUERY = "SELECT * FROM " + BD_TABLE + " WHERE id_usuario = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, idUsuario);
            ResultSet rs = query.executeQuery();
          
            if(rs.next()){
                Monedero item = new Monedero(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getString("dinero")
                );
                
                return item;
            }
            return null;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int insert(Monedero item){
         final String QUERY = "INSERT INTO " + BD_TABLE 
                 + " (id_usuario, dinero) "
                 + " VALUES (?, ?)";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, item.getIdUsuario());
            query.setString(2, item.getDinero());

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
    
        
    public int updateDinero(int idUsuario, String dinero){
         final String QUERY = "UPDATE " + BD_TABLE 
                 + " SET dinero = ? "
                 + " WHERE id_usuario = ? ";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setString(1, dinero);
            query.setInt(2, idUsuario);

            return query.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}

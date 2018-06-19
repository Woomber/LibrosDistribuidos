package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Mensaje;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class MensajeController extends Controller {
    
    private static final String BD_TABLE = "mensaje";

    public ArrayList<Mensaje> get(){
        final String QUERY = "SELECT * FROM " + BD_TABLE;
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            ResultSet rs = query.executeQuery();
            
            ArrayList<Mensaje> resultados = new ArrayList<>();
            
            while(rs.next()){
                Mensaje item = new Mensaje(
                        rs.getInt("id"),
                        rs.getString("mensaje"),
                        rs.getDate("fecha"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_foro")
                );
                resultados.add(item);
            }
            return resultados;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public Mensaje getById(int id){
        final String QUERY = "SELECT * FROM " + BD_TABLE + " WHERE id = ?";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
          
            if(rs.next()){
                Mensaje item = new Mensaje(
                        rs.getInt("id"),
                        rs.getString("mensaje"),
                        rs.getDate("fecha"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_foro")
                );
                
                return item;
            }
            return null;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int insert(Mensaje item){
         final String QUERY = "INSERT INTO " + BD_TABLE 
                 + " (mensaje, id_usuario, fecha, id_foro) "
                 + " VALUES (?, ?, NOW(), ?)";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, item.getMensaje());
            query.setInt(2, item.getIdUsuario());
            query.setInt(3, item.getIdForo());

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

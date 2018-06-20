package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Foro;
import models.Usuario;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class ForoController extends Controller {
    
    private static final String BD_TABLE = "foro";

    public ArrayList<Foro> get(){
        final String QUERY = "SELECT * FROM " + BD_TABLE;
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY);
            ResultSet rs = query.executeQuery();
            
            ArrayList<Foro> resultados = new ArrayList<>();
            
            while(rs.next()){
                Foro item = new Foro(
                        rs.getInt("id")
                );
                
                resultados.add(item);
            }
            return resultados;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public int insert(){
         final String QUERY = "INSERT INTO " + BD_TABLE + " VALUES ()";
        
        try {
            PreparedStatement query = connection.prepareStatement(QUERY, 
                    Statement.RETURN_GENERATED_KEYS);
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

package Code;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
   public static Connection Conexion(){
       
       Connection conex = null;
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
           conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/heladeria", "root", "");
           System.out.println("Conectado");
       } catch(Exception error){
           System.out.println("Error en la conexion: "+error);
       }
       
       
       return conex;
   }
}

package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilmer Parra
 */
public class ProductosBD implements Heladeria{
    
  
    @Override
    public List Listado(){
        
        List<Producto> Prod = new ArrayList<>();
        
         try{
             Connection conex; 
             conex = Conexion.Conexion();
             PreparedStatement union;
             union = conex.prepareStatement("SELECT * FROM productos WHERE Estado = 'Disponible' ");
             ResultSet muestra;
             muestra = union.executeQuery();
             
             while(muestra.next()){
                 
                 Producto listar = new Producto();
                 
                 listar.setId(muestra.getInt(1));
                 listar.setSabores(muestra.getString(2));
                 listar.setDescripcion(muestra.getString(3));
                 listar.setPrecio(muestra.getDouble(4));
                 listar.setDescuento(muestra.getString(5));
                 listar.setCantidad(muestra.getInt(6));
                 Prod.add(listar);
             }
        } catch(SQLException error){
            System.out.println("Error en ListarBD: "+error);
        }
         return Prod;
    }
    
    @Override
    public int Ingresar(Object [] obj){
        
        int resp = 0;
        try{
            Connection conex = Conexion.Conexion();
            PreparedStatement enlace;
            enlace = conex.prepareStatement("INSERT INTO productos (Sabor, Descripcion, Precio, Descuento, Cantidad, Estado) values (?, ?, ?, ?, ?, ?)");
            enlace.setObject(1, obj[0]);
            enlace.setObject(2, obj[1]);
            enlace.setObject(3, obj[2]);
            enlace.setObject(4, obj[3]);
            enlace.setObject(5, obj[4]);
            enlace.setObject(6, obj[5]);
            enlace.executeUpdate(); // Actualiza la Base de Datos
            
            JOptionPane.showMessageDialog(null, "Se Agrego Exitosamente");
        } catch(SQLException error){
            System.out.println("Error en IngresarBD: "+error);
        }
        return resp;
    }
    
    @Override
    public int Modificar(Object [] obj){
        int resp = 0;
         try{
             Connection conex = Conexion.Conexion();
             PreparedStatement enlace = conex.prepareStatement("UPDATE productos SET Sabor = ?, Descripcion = ?, Precio = ?, Descuento = ?, Cantidad = ?, Estado = ? WHERE IdProducto = ?");
             enlace.setObject(1, obj[0]);
             enlace.setObject(2, obj[1]);
             enlace.setObject(3, obj[2]);
             enlace.setObject(4, obj[3]);
             enlace.setObject(5, obj[4]);
             enlace.setObject(6, obj[5]);
             enlace.setObject(7, obj[6]);
             enlace.executeUpdate();
             
            JOptionPane.showMessageDialog(null, "Se Modificó Exitosamente");
        } catch(SQLException error){
            System.out.println("Error en ModificarBD: "+error);
        }
         
         return resp;
    }  
    
    @Override
    public List ListarAgotados(){
        
        List<Producto> Agotado = new ArrayList<>();
        
         try{
             Connection conex; 
             conex = Conexion.Conexion();
             PreparedStatement union;
             union = conex.prepareStatement("SELECT * FROM productos WHERE Estado = 'Agotado' ");
             ResultSet muestra;
             muestra = union.executeQuery();
             
             while(muestra.next()){
                 
                 Producto listar = new Producto();
                 
                 listar.setId(muestra.getInt(1));
                 listar.setSabores(muestra.getString(2));
                 listar.setDescripcion(muestra.getString(3));
                 listar.setPrecio(muestra.getDouble(4));
                 listar.setDescuento(muestra.getString(5));
                 listar.setEstado(muestra.getString(7));
                 Agotado.add(listar);
             }
        } catch(SQLException error){
            System.out.println("Error en ListarBD: "+error);
        }
         return Agotado;
        
    }

    @Override
    public int ModificarAgotados(Object[] obj) {
        int resp = 0;
        
        try{
       Connection BD = Conexion.Conexion();
       PreparedStatement Union = BD.prepareStatement("UPDATE productos SET Estado = ? WHERE IdProducto = ?");
            /*Union.setObject(1, obj[0]);
             Union.setObject(2, obj[1]);
             Union.setObject(3, obj[2]);
             Union.setObject(4, obj[3]);
             Union.setObject(5, obj[4]); */
           Union.setObject(1, obj[0]);
           Union.setObject(2, obj[1]);
           Union.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Se Modificó Exitosamente");
        }catch(SQLException error){
            System.out.println("Error al ModificarBD: "+error);
        }
    
        return resp;
    }
}

package consulta;

import conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoprogra4.vendedor;


public class ConsultasVendedor extends conexion {
    
    public boolean registrar(vendedor p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO vendedor (id,Nombre,Edad,password) VALUES (?,?,?,?)";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getEdad());
            ps.execute();
            return true;
            
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(vendedor p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE vendedor SET id=?, Nombre=?, Edad=? WHERE id=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getEdad());
            ps.setInt(4, p.getId());
            ps.execute();
            return true;
            
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    public boolean eliminar(vendedor p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM vendedor WHERE id=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setInt(4, p.getId());
            ps.execute();
            return true;
            
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    public boolean buscar(vendedor p)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM vendedor WHERE id=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setInt(4, p.getId());
            rs = ps.executeQuery();
            
            
            if(rs.next())
            {
                p.setId( Integer.parseInt(rs.getString("id")));
                p.setNombre(rs.getString("nombre"));
                p.setId( Integer.parseInt(rs.getString("edad")));
                return true;
                
                
            }
            
            return true;
            
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
}

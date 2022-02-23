
package consulta;

import conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoprogra4.cartelera;





public class ConsultaCartelera extends conexion{
    public boolean Agregar(cartelera car) {
        
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "Insert into cartelera(Pelicula,Horario,TipoSala,Idioma) VALUES (?,?,?,?)";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, car.getPelicula());
			ps.setString(2, car.getHorario());
			ps.setString(3, car.getTipoSala());
			ps.setString(4, car.getIdioma());
			
                       
			ps.execute();
			System.out.println("se guardo registro");
									return true;
		} catch (SQLException ex) {											
																																																																																																	System.out.println("error" + ex);	
																																																																																																	return false;
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println("error" + ex);
			}
		}
	}
    public boolean editar(cartelera car)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE cartelera SET Pelicula=?, Horario=?, TipoSala=?, Idioma=? WHERE Pelicula=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getPelicula());
            ps.setString(2, car.getHorario());
            ps.setString(3, car.getTipoSala());
            ps.setString(4, car.getIdioma());
            ps.setString(5, car.getPelicula());
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
    public boolean eliminar(cartelera car)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM cartelera WHERE Pelicula=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getPelicula());
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
    public boolean buscar(cartelera car)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM cartelera WHERE Pelicula=?";
        
        
        try{
        
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getPelicula());
            rs = ps.executeQuery();
            
            
            if(rs.next())
            {
                car.setPelicula((rs.getString("Pelicula")));
                car.setHorario(rs.getString("Horario"));
                car.setTipoSala((rs.getString("TipoSala")));
                car.setIdioma((rs.getString("Idioma")));
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


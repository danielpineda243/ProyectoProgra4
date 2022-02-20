
package consulta;

import conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectoprogra4.cartelera;



public class ConsultaCartelera extends conexion{
    public boolean Agregar(cartelera car) {
        
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "Insert into cartelera(Pelicula,Horario,TipoSala,Idioma)";
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
}


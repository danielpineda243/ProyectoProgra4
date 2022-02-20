package consulta;

import conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectoprogra4.facturar;

public class consultafactura extends conexion {

	public boolean Registrar(facturar fac) {
        
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "Insert into factura(idfactura,nombrefatura,fecha,asiento,sala,hora,idusuario,idvendedor,idpelicula,subtotal,total,descuento";
		try {
System.out.println("llego a consulta"	);
System.out.println(" pasa por"+fac.getNpelicula() );
			ps = con.prepareStatement(sql);
			ps.setInt(1, fac.getNumFactura());
			ps.setString(2, fac.getNombre());
			ps.setString(3, fac.getFecha());
			ps.setInt(4, fac.getNumeroAsiento());
			ps.setInt(5, fac.getNumeroSala());
			ps.setInt(6, Integer.parseInt(fac.getHora()));
			ps.setInt(7, fac.getIdcliente());
			ps.setInt(8, fac.getIdvendedor());
			ps.setInt(9, fac.getNpelicula());
			ps.setFloat(10, fac.getPrecio());
			ps.setFloat(11, fac.getTotal());
			ps.setFloat(12, fac.getDescuento());
                       
//			ps.execute();
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

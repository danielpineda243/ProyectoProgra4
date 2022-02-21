package consulta;

import conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoprogra4.cliente;

public class ConsultaCliente extends conexion {

    public boolean Agregar(cliente clie) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "Insert into cliente (Nombre, Edad, id)";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, clie.getNombre());
            ps.setInt(2, clie.getEdad());
            ps.setInt(3, clie.getId());
            ps.execute();
            System.out.println("Se guardo registro");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ERROR" + ex);
            }
        }

    }

    public boolean Editar(cliente clie) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "update cliente set id=?, Nombre=?, Edad=? where id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1,clie.getNombre());
            ps.setInt(2, clie.getEdad());
            ps.setInt(3, clie.getId());
            ps.execute();
            System.out.println("Se guardo registro");
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean Borrar(cliente clie) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "delete from cliente where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(4, clie.getId());
            ps.execute();
            return true;
           

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(cliente clie) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM cliente WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(4, clie.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                clie.setId(Integer.parseInt(rs.getString("id")));
                clie.setNombre(rs.getString("nombre"));
                clie.setId(Integer.parseInt(rs.getString("edad")));
                return true;

            }

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}

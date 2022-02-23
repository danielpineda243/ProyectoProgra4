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

        String sql = "Insert into cliente (Nombre, Edad, id )VALUES (?,?,?)";
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

        String sql = "update cliente set Nombre=?, Edad=?, id=? WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1,clie.getNombre());
            ps.setInt(2, clie.getEdad());
            ps.setInt(3, clie.getId());
            ps.setInt(4, clie.getId());
            ps.execute();
            System.out.println("Se Edito el registro");
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

        String sql = "delete from cliente WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, clie.getId());
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
            ps.setInt(1, clie.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                //Estos datos deben estar igual escritos como en la base de datos si Nombre esta en mayuscula en bd asi debe ser aqui.
                  clie.setNombre(rs.getString("Nombre"));
                clie.setEdad(Integer.parseInt(rs.getString("Edad")));
                clie.setId(Integer.parseInt(rs.getString("id")));
              System.out.println (clie.getId()+ clie.getNombre()+ clie.getEdad());
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

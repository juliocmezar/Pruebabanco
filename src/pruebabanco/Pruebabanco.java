package pruebabanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pruebabanco {

    public static Connection conectar() {
        String usuario = "";
        String contrasena = "#3Programacion3";
        String url = "jdbc:mysql://72.167.84.254/banco";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("conexion correcta");
        } catch (Exception e) {
            System.out.println("Conexión incorrecta");
        }
        return con;

    }

    public static void main(String[] args) {
        Connection con = conectar();
        String query = "";
        try {

            //este tipo de consulta es para insertar, editar y eliminar
            query = "INSERT INTO clientes (id, nombre, apellido, telefono, ciudad, ncuenta, saldo, estado) VALUES (NULL, 'María', 'Serna', '3214567654', 'Manizales', 123, 1000000, 0);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();

            System.out.println("Consulta correcta");
        } catch (SQLException ex) {
            System.out.println("Error en el sql");

        }
    }

}

package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.SumaProveedor;
import controller.ControladorRequerimientosReto5;

public class SumaProveedorDao {

    private String textoSumaProveedorDao;

    public ArrayList<SumaProveedor> rankingSumaProveedor() throws SQLException {

        ArrayList<SumaProveedor> respuesta = new ArrayList<SumaProveedor>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT SUM(c.Cantidad) as 'suma'" + "FROM Compra c " + "WHERE c.Proveedor ='JUMBO';";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SumaProveedor sumaProveedor = new SumaProveedor();
                sumaProveedor.setSuma(resultSet.getString("suma"));
                respuesta.add(sumaProveedor);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando Suma Proveedor!!" + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return respuesta;
    }

    public String getTextoSumaProveedorDao() {
        ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();

        try {
            textoSumaProveedorDao = String.format("%s %n", "-----Suma Cantidades-------");
            textoSumaProveedorDao += String.format("%s %n", "Suma Cantidades");
            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();
            for (SumaProveedor p : rankingSumaProveedor) {
                textoSumaProveedorDao += String.format("%s %n", p.getSuma());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return textoSumaProveedorDao;
    }

    public void setTextoSumaProveedorDao(String textoSumaProveedorDao) {
        this.textoSumaProveedorDao = textoSumaProveedorDao;
    }
}
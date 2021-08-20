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
import model.vo.LiderCiudad;
import controller.ControladorRequerimientosReto5;

public class LiderCiudadDao {

    private String textoLiderCiudadDao;

    public ArrayList<LiderCiudad> rankingLiderCiudad() throws SQLException {

        ArrayList<LiderCiudad> respuesta = new ArrayList<LiderCiudad>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT Nombre ||' '|| Primer_Apellido ||' '|| Segundo_Apellido " + "AS 'Nombre Líder' "
                    + "FROM Lider " + "WHERE Ciudad_Residencia ='Dubai';";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LiderCiudad liderCiudad = new LiderCiudad();
                liderCiudad.setNombreLider(resultSet.getString("Nombre Líder"));
                respuesta.add(liderCiudad);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando Lider Ciudad!!" + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return respuesta;
    }

    public String getTextoLiderCiudadDao() {
        ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();

        try {
            textoLiderCiudadDao = String.format("%s %n", "-----Líder Ciudad-------");
            textoLiderCiudadDao += String.format("%s %n", "Nombre Líder");
            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();
            for (LiderCiudad p : rankingLiderCiudad) {
                textoLiderCiudadDao += String.format("%s %n", p.getNombreLider());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return textoLiderCiudadDao;
    }

    public void setTextoLiderCiudadDao(String textoLiderCiudadDao) {
        this.textoLiderCiudadDao = textoLiderCiudadDao;
    }

}
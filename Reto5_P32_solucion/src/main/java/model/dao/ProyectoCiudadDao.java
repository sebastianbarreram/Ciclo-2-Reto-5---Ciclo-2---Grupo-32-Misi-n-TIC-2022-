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
import model.vo.ProyectoCiudad;
import controller.ControladorRequerimientosReto5;

public class ProyectoCiudadDao {

    private String textoProyectoCiudadDao;

    public ArrayList<ProyectoCiudad> rankingProyectosCiudad() throws SQLException {

        ArrayList<ProyectoCiudad> respuesta = new ArrayList<ProyectoCiudad>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT Constructora, " + "Fecha_Inicio, " + "Clasificacion " + "FROM Proyecto "
                    + "WHERE Ciudad = 'Santa Marta';";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ProyectoCiudad proyectoCiudad = new ProyectoCiudad();
                proyectoCiudad.setConstructora(resultSet.getString("Constructora"));
                proyectoCiudad.setFechaInicio(resultSet.getString("Fecha_Inicio"));
                proyectoCiudad.setClasificacion(resultSet.getString("Clasificacion"));
                respuesta.add(proyectoCiudad);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando Proyecto Ciudad!!" + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return respuesta;
    }


    public String getTextoProyectoCiudadDao() {
        ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();
        
        try {
            textoProyectoCiudadDao=String.format("%s %n", "-----Proyecto Ciudad-------");
            textoProyectoCiudadDao+=String.format("%s %n", "Constructora Fecha_Inicio Clasificación");
            ArrayList<ProyectoCiudad> rankingProyectosCiudad = controlador.consultarProyectoCiudad();
            for (ProyectoCiudad p : rankingProyectosCiudad) {
                textoProyectoCiudadDao += String.format("%s %s %s %n",p.getConstructora(), p.getFechaInicio(),p.getClasificacion());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return textoProyectoCiudadDao;
    }

    public void setTextoProyectoCiudadDao(String textoProyectoCiudadDao) {
        this.textoProyectoCiudadDao = textoProyectoCiudadDao;
    }
    
}
package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.ProyectoCiudadDao;
import model.vo.ProyectoCiudad;
import model.dao.LiderCiudadDao;
import model.vo.LiderCiudad;
import model.dao.SumaProveedorDao;
import model.vo.SumaProveedor;

import view.VistaRequerimientosReto5;

//Librerías para bases de datos
import java.sql.SQLException;

import java.awt.event.*;

public class ControladorRequerimientosReto5 implements ActionListener {

    private VistaRequerimientosReto5 vista;
    private ProyectoCiudadDao modelo1;
    private SumaProveedorDao modelo2;
    private LiderCiudadDao modelo3;

    // private LiderCiudadDao liderCiudadDao;

    public ControladorRequerimientosReto5() {
        this.modelo1 = new ProyectoCiudadDao();
        this.modelo2 = new SumaProveedorDao();
        this.modelo3 = new LiderCiudadDao();
    }

    public ControladorRequerimientosReto5(VistaRequerimientosReto5 vista, ProyectoCiudadDao modelo1,
            SumaProveedorDao modelo2, LiderCiudadDao modelo3) {
        this.vista = vista;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
        this.modelo3 = modelo3;
        this.vista.btnProyectoCiudad.addActionListener(this);
        this.vista.btnSumaProveedor.addActionListener(this);
        this.vista.btnLiderCiudad.addActionListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == vista.btnProyectoCiudad) {
            //vista.txtRespuesta.setText("");
            vista.txtRespuesta.setText(modelo1.getTextoProyectoCiudadDao());
        }

        else if (evt.getSource() == vista.btnSumaProveedor) {
            //vista.txtRespuesta.setText("");
            vista.txtRespuesta.setText(modelo2.getTextoSumaProveedorDao());
        }

        else if (evt.getSource() == vista.btnLiderCiudad) {
            //vista.txtRespuesta.setText("");
            vista.txtRespuesta.setText(modelo3.getTextoLiderCiudadDao());
        }

    }

    public ArrayList<ProyectoCiudad> consultarProyectoCiudad() throws SQLException {
        return this.modelo1.rankingProyectosCiudad();
    }

    public ArrayList<SumaProveedor> consultarSumaProveedor() throws SQLException {
        return this.modelo2.rankingSumaProveedor();
    }

    public ArrayList<LiderCiudad> consultarLiderCiudad() throws SQLException {
    return this.modelo3.rankingLiderCiudad(); 
}

    // Con esto sé si está tomando la accion del click
    /*
     * Para que funcione se tiene que colocar el atributo numClicks al principio de
     * la clase: -> private int numClicks = 0; public void
     * actionPerformed(ActionEvent e) { System.out.println("Aquí está");
     * 
     * numClicks++; System.out.println("Button Clicked " + numClicks + " times"); }
     */
}
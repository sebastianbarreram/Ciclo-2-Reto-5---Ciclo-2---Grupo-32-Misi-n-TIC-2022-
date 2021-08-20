package view;

import controller.ControladorRequerimientosReto5;

import java.awt.Color;

import javax.swing.*;

public class VistaRequerimientosReto5 extends JFrame {

    public static ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();

    public JButton btnProyectoCiudad = new JButton("<html><p>Proyecto</p><p>Ciudad</p></html>");
    public JButton btnSumaProveedor = new JButton("<html><p>Suma</p><p>Proveedor</p></html>");
    public JButton btnLiderCiudad = new JButton("<html><p>Líder</p><p>Ciudad</p></html>");
    public JTextArea txtRespuesta;

    public JLabel img = new JLabel(new ImageIcon("img/Imagen.png"));
    public JLabel label1 = new JLabel("Seleccione la consulta que desea visualizar");

    public VistaRequerimientosReto5() {
        JPanel panelInterfaz = new JPanel();
        panelInterfaz.setBackground(Color.WHITE);

        this.setTitle("Reto 5 - Ciclo 2 - Grupo 32 por Sebastian Barrera Marín ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 600, 640);

        img.setBounds(193, 0, 214, 76);
        this.add(img);

        label1.setBounds(175, 96, 250, 20);
        this.add(label1);

        btnProyectoCiudad.setBounds(110, 136, 100, 50);
        this.add(btnProyectoCiudad);

        btnSumaProveedor.setBounds(250, 136, 100, 50);
        this.add(btnSumaProveedor);

        btnLiderCiudad.setBounds(390, 136, 100, 50);
        this.add(btnLiderCiudad);

        txtRespuesta = new JTextArea();
        txtRespuesta.setBounds(100, 206, 400, 380);
        txtRespuesta.setBackground(Color.LIGHT_GRAY);
        this.add(txtRespuesta);

        this.add(panelInterfaz);
    }

}
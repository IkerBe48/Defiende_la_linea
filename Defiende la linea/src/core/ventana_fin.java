package core;

import javax.swing.*;

public class ventana_fin extends JFrame {

    private static double vAncho = 690;
    private static double vAlto = 800;

    private static String vNombre;

    public ventana_fin(String vNombre, double vAncho, double vAlto){
        super(vNombre);
        ventana_fin.vNombre = vNombre;
        ventana_fin.vAncho = vAncho;
        ventana_fin.vAlto = vAlto;

        atributosventana();
    }

    public void packWindow(){
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void atributosventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static double getvAlto() {
        return vAlto;
    }

    public static double getvAncho() {
        return vAncho;
    }

    public static String getvNombre(){
        return vNombre;
    }
}

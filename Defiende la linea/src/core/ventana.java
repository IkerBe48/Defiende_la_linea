package core;

import javax.swing.*;
import java.awt.*;

public class ventana extends JFrame {

    private static double vAncho = 690;
    private static double vAlto = 800;

    private static String vNombre;

    public ventana(String vNombre, double vAncho, double vAlto){
        super(vNombre);
        ventana.vNombre = vNombre;
        ventana.vAncho = vAncho;
        ventana.vAlto = vAlto;

        atributosventana();
    }

    public void packWindow(){
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    private void atributosventana(){
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

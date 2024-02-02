package objetos;

import core.FPS;
import core.Input;
import core.Timer;
import core.ventana;
import renders.Renderable;
import renders.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Soldado implements Renderable {
    private static double ancho = 50;
    private static double alto = 75;
    private double x;
    private double y;
    private int capa = 2;
    private static BufferedImage soldado;

    private double velocidad = 300;

    private static int Tiempodisparomillis = 500;

    Timer timer = new Timer(Tiempodisparomillis);

    public Soldado(double x, double y) throws IOException {
        this.x = x;
        this.y = y;

        soldado = ImageIO.read(new File("res/soldado_normal.png"));
        Renderer.addRendereableObj(this);
    }


    public static void setAncho(double ancho) {
        Soldado.ancho = ancho;
    }


    public static void setAlto(double alto) {
        Soldado.alto = alto;
    }

    @Override
    public double getAncho() {
        return ancho;
    }

    @Override
    public double getAlto() {
        return alto;
    }


    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(soldado, (int)x, (int)y, (int)ancho,(int)alto,null);
    }

    @Override
    public int obtLayer() {
        return capa;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }


}

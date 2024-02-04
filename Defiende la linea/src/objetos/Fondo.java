package objetos;

import renders.Renderable;
import renders.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fondo implements Renderable, Updateable{
    private static double ancho = 700;
    private static double alto = 800;
    private double x;
    private double y;
    private int capa = 1;
    private static BufferedImage fondo;

    public Fondo(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        //Se obtiene la imagen que queremos para el fondo
        fondo = ImageIO.read(new File("res/fondo.PNG"));
        Renderer.addRendereableObj(this);
        Updater.AddupdateableObj(this);
    }


    public static void setAncho(double ancho) {
        Fondo.ancho = ancho;
    }


    public static void setAlto(double alto) {
        Fondo.alto = alto;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double getAncho() {
        return ancho;
    }

    @Override
    public double getAlto() {
        return alto;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Renderable getRenderable() {
        return null;
    }

    public void setY(double y) {
        this.y = y;
    }
    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(fondo, (int) x, (int) y, (int) ancho, (int) alto, null);
        }

        @Override
        public int obtLayer () {
            return capa;
        }

        @Override
        public void update () throws IOException { //No se si hace falta aqui{

        }

}






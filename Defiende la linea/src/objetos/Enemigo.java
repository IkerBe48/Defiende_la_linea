package objetos;

import com.sun.tools.javac.Main;
import core.FPS;
import core.Input;
import core.Timer;
import core.ventana;
import core.ventana_fin;
import renders.Renderable;
import renders.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class Enemigo implements  Updateable, Renderable{
    private static double ancho = 80;
    private static double alto = 80;
    private double x;
    private double y;
    private int capa = 2;
    private static BufferedImage enemigo;

    private double velocidad = 100;

    Random random = new Random();

    public Enemigo() throws IOException {
        int dimensiones = random.nextInt(75 +1);

        /*if (dimensiones < 35)
            dimensiones = 35;*/

        //ancho = dimensiones;
        //alto = dimensiones;

        int posX = random.nextInt((int) ventana.getvAncho()- (int) getAncho() + 1);
        this.x = posX;
        this.y = -getAlto();

        enemigo = ImageIO.read(new File("res/enemigo.png"));
        Renderer.addRendereableObj(this);
        Updater.AddupdateableObj(this);

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
    public String getID() {
        return "enemigo";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }

    public void setY(double y) {
        this.y = y;
    }
    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(enemigo, (int) x, (int) y, (int) ancho, (int) alto, null);
    }

    @Override
    public int obtLayer () {
        return capa;
    }

    @Override
    public void update () throws IOException {
        y += velocidad * FPS.obtTiempodelta();

        if (y >= ventana.getvAlto()){
            Updater.BorrarupdateableObj(this);
            Updater.BorrarupdateableObj(this);
        }
        Updateable objcolisionando = colisionando(this, "fondo_linea");
        //System.out.println(y);
        if (objcolisionando != null) {
            throw new IOException("FIN");
        }
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
}

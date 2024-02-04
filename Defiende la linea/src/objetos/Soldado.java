package objetos;

import core.FPS;
import core.Input;
import core.Timer;
import core.ventana;
import renders.Renderable;
import renders.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Soldado implements Renderable, Updateable {
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
        Updater.AddupdateableObj(this);
    }


    public static void setAncho(double ancho) {
        Soldado.ancho = ancho;
    }


    public static void setAlto(double alto) {
        Soldado.alto = alto;
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
        return "soldado";
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
        g.drawImage(soldado, (int)x, (int)y, (int)ancho,(int)alto,null);
    }

    @Override
    public int obtLayer() {
        return capa;
    }

    @Override
    public void update() throws IOException{
        //Dependiendo de que INPUT devuelva true, se movera a la izquierda, derecha o disparará
        if (Input.teclas[Input.DER]&& x<= ventana.getvAncho()-ancho)
            x += velocidad * FPS.obtTiempodelta();
        if (Input.teclas[Input.IZQ] && x >= 0)
            x -= velocidad * FPS.obtTiempodelta();
        if (Input.teclas[Input.ESPACIO] && timer.estaSonando()) {
            new Bala(x + (getAncho() / 2), y);
            timer.resetTiempo();
        }
        //Si enemigo toca a Soldado, el soldado desaparece
        Updateable objcolisionando = colisionando(this, "enemigo");

        if (objcolisionando != null) {
            Updater.BorrarupdateableObj(this);
            Renderer.borrarRendereableObj(this);

            Updater.BorrarupdateableObj(objcolisionando);
            Renderer.borrarRendereableObj(objcolisionando.getRenderable());
        }
    }
}

package objetos;

import core.FPS;
import renders.Renderable;
import renders.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static core.FPS.*;


public class Bala implements Updateable, Renderable {
    private static double ancho = 15;

    private static double alto = 20;
    private double x;
    private double y;
    private final int capa = 1;
    private static BufferedImage bala;
    public static double velocidad = 1000;

    public Bala(double x, double y) throws IOException{
        this.x = x - (getWidth()/2);
        this.y = y;

        bala = ImageIO.read(new File("res/bala.png"));

        Renderer.addRendereableObj(this);
        Updater.AddupdateableObj(this);
    }

    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(bala, (int)x, (int)y, (int)ancho,(int)alto,null);
    }

    @Override
    public int obtLayer() {
        return capa;
    }

    @Override
    public void update() throws IOException {

        y -= velocidad * FPS.obtTiempodelta();

        if (y < -getAlto()){
            Updater.BorrarupdateableObj(this);
            Renderer.borrarRendereableObj(this);
        }
        //Si la bala colisiona con un enemigo, ambos sprties desapareceran del contenedor de renderers
        //Y no seguiran su movimiento habitual
        Updateable objcolisionando = colisionando(this, "enemigo");
        if (objcolisionando != null) {

            Updater.BorrarupdateableObj(this);
            Renderer.borrarRendereableObj(this);

            Updater.BorrarupdateableObj(objcolisionando);
            Renderer.borrarRendereableObj(objcolisionando.getRenderable());

            //numenemigos = numenemigos+1;

        }
    }
@Override
    public double getX() {
        return x;
    }
    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getAncho() {
        return ancho;
    }

    @Override
    public String getID() {
        return "bala";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }

    public double getWidth() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }


}

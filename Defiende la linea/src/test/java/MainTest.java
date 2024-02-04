package test.java;
import com.sun.tools.javac.Main;
import core.FPS;
import core.Input;
import core.Timer;
import core.ventana;
import objetos.Bala;
import objetos.Enemigo;
import objetos.Soldado;
import objetos.Spawner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import renders.Renderable;
import update.Updateable;
import update.Updater;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    //Esta prueba muestra si, enviandole una cantidad de milisegundos,
    //el timer esta sonando o no
    public void testSpawner() throws IOException {

        Spawner spawner = new Spawner();
        //Si está en negativo,
        Timer tiempo = new Timer(1);

        spawner.update();
        if (tiempo.estaSonando()) {
            new Enemigo();

            tiempo.resetTiempo();
        }
        System.out.println(tiempo.estaSonando());
        if (tiempo.estaSonando())
            Assert.assertTrue("El timer esta sonando y por lo tanto no aparecen enemigos", tiempo.estaSonando());
        else
            Assert.assertTrue("El timer no esta sonando y por lo tanto aparecen enemigos", tiempo.estaSonando());
    }

    @Test
    public void test1() throws IOException {

        Input input = new Input();

         input.teclas = new boolean[3];
        //Solo valen los numeros 0, 1 y 2
        int tecla = 0;

        if (tecla == 1 || tecla == 2 || tecla == 0) {
            input.teclas[tecla] = true;
        }
        Assert.assertTrue("Tecla correcta", input.teclas[tecla]);
    }

    @Test
    public void test3() throws IOException {
        final ScheduledExecutorService programador = Executors.newScheduledThreadPool(1);
        boolean fin[] = new boolean[]{true};
        int contadorinicio = 2;
        final Runnable ejecutable = new Runnable() {
            public void run() {
                if (contadorinicio <= 0) {

                    fin[0] = true;
                } else {
                    fin[0] = false;
                }
            }
        };
        programador.scheduleAtFixedRate(ejecutable, 0, 1, SECONDS);
        System.out.println("El contador " + contadorinicio);
        if (fin[0] == false) {
            System.out.println("El contador no ha finalizado " + fin[0]);
            Assert.assertEquals(contadorinicio <= 0, true);
        } else {
            System.out.println("El contador ha finalizado " + fin[0]);
            Assert.assertEquals(contadorinicio <= 0, true);

        }

    }

}





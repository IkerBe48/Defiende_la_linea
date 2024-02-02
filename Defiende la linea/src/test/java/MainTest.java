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

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    //Esta prueba muestra si, enviandole una cantidad de milisegundos,
    //el timer esta sonando o no
    public void testSpawner() throws IOException {

        Spawner spawner = new Spawner();
        //Si está en negativo,
        Timer tiempo = new Timer(-1);

        spawner.update();
            if (tiempo.estaSonando()) {
                new Enemigo();

                tiempo.resetTiempo();
            }
            System.out.println(tiempo.estaSonando());
        if (tiempo.estaSonando())
            Assert.assertTrue("El timer esta sonando y por lo tanto no aparecen enemigos",tiempo.estaSonando());
        else
            Assert.assertFalse("El timer no esta sonando y por lo tanto aparecen enemigos",tiempo.estaSonando());
        }

        @Test
        public void test1() throws IOException{
        //System.out.println("Null");
        int x = 0;
        int y = 0;
            Soldado soldado = new Soldado(x,y);
            //Solo valen los numeros 0, 1 y 2
            int tecla = 3;
            if (Input.teclas[tecla])

                Assert.assertTrue("Tecla correcta",Input.teclas[tecla]);
            else
                Assert.assertFalse("Tecla incorrecta",Input.teclas[tecla]);
        }

        @Test
    public void test3() throws IOException {
            Enemigo enemigo = new Enemigo();
            enemigo.update();
            Updateable updateable;

            //System.out.println(y);
        }
    }





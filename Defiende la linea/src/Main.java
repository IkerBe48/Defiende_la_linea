import core.*;
import objetos.Soldado;
import renders.Renderer;

import java.awt.*;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        final ScheduledExecutorService programador = Executors.newScheduledThreadPool(1);
        final boolean[] arrancaJuego = {true};
        final Runnable ejecutable = new Runnable() {
            int contadorinicio = 20;

            public void run() {
                contadorinicio--;

                if (contadorinicio < 0) try {
                    arrancaJuego[0] = false;
                        throw new IOException("FIN");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                }
            }

        };
        programador.scheduleAtFixedRate(ejecutable, 0, 1, SECONDS);

        Window pantalla = new ventana("Defiende la frontera", ventana.getvAncho(),ventana.getvAlto());
        Renderer renderer = new Renderer();

        pantalla.addKeyListener(new Input());
        pantalla.add(renderer);
        ((ventana) pantalla).packWindow();
        pantalla.setVisible(true);
        //Arranca el juego
        //oolean arrancaJuego = true;
        new Soldado(300,680);
        FPS.calcinicioTiempo();
        while (arrancaJuego[0]) {
            //actualizamos el estado del juego
            renderer.repaint();
            //mostramos el juego
           //recalculamos el tiempo delta
            FPS.calcTiempodelta();
        }

    }
}
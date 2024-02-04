package objetos;

import core.Timer;
import renders.Renderable;
import renders.Renderer;
import update.Updateable;
import update.Updater;

import java.io.IOException;

public class Spawner implements Updateable {
    //Se llama al temporizador y en este caso queremos que cada segundo aparezca un enemigo nuevo
    Timer tiempo = new Timer(1000);

    public Spawner(){
        Updater.AddupdateableObj(this);
    }

    @Override
    public void update() throws IOException {
        //Cada 1000 milisegundos, genera 1 enemigo y resetea el contador
        if (tiempo.estaSonando()) {
            new Enemigo();
            tiempo.resetTiempo();
        }
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Renderable getRenderable() {
        return null;
    }
}

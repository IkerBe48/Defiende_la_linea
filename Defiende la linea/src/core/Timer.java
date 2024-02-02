package core;

import renders.Renderable;
import update.Updateable;
import update.Updater;

import java.io.IOException;

public class Timer implements Updateable {
    int setMillisTiempo = 0;
    int empezarMillisTiempo;

    public Timer(int setMillisTiempo){
        this.empezarMillisTiempo = setMillisTiempo;
        Updater.AddupdateableObj(this);
    }

    @Override
    public void update() throws IOException {


        setMillisTiempo -= FPS.obtTiempodelta() * 1000;
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

    //Si el timer esta sonando devuelve true y por lo tanto, en las llamadas a este metodo
    //Si los milisegundos son negativos o 0, termina.
    public boolean estaSonando(){
        if (setMillisTiempo <= 0) {
            return true;
        }
        return false;
    }
    public Object resetTiempo(){
            setMillisTiempo = empezarMillisTiempo;
        return null;
    }

}

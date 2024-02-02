package core;

import renders.Renderable;

import java.io.IOException;

public class Timer {
    int setMillisTiempo = 0;
    int empezarMillisTiempo;

    public Timer(int setMillisTiempo){
        this.empezarMillisTiempo = setMillisTiempo;
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

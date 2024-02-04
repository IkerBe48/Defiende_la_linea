package core;

import java.time.Duration;
import java.time.Instant;

public class FPS {
    public FPS() {}

    private  static Duration fpstiempoDelta = Duration.ZERO;

    private  static Duration finTiempo = Duration.ZERO;
    private  static Instant inicioTiempo = Instant.now();
    public static double tiempoDelta = fpstiempoDelta.toMillis() - finTiempo.toMillis();
    //El tiempo inicia en 0
    public static void calcinicioTiempo(){
        inicioTiempo = Instant.now();
        fpstiempoDelta = Duration.ZERO;
    }
    //Se calcula el tiempo delta en milisegundos
    public static void calcTiempodelta(){
        fpstiempoDelta = Duration.between(inicioTiempo, Instant.now());
        tiempoDelta = (double)fpstiempoDelta.toMillis() - finTiempo.toMillis();
        finTiempo = fpstiempoDelta;
    }
    //Se obtiene 1 segundo
    public static  double obtTiempodelta(){
        return tiempoDelta / 1000;
    }

}

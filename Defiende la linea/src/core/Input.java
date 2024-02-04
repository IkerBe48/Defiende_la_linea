package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public static final  int IZQ = 0;
    public static final  int DER = 1;
    public static final  int ESPACIO = 2;

    public static boolean[] teclas = new boolean[3];
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //El evento getKeyCode obtiene el input por teclado. Dependiendo de la tecla, devolera true para iniciar otro evento
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            teclas[IZQ] = true;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            teclas[DER] = true;
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            teclas[ESPACIO] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            teclas[IZQ] = false;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            teclas[DER] = false;
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            teclas[ESPACIO] = false;
    }

}

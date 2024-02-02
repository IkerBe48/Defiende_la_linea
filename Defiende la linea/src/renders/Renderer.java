package renders;

import core.Input;
import core.ventana;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Renderer extends JPanel {
    private static ArrayList<Renderable> renderableObj = new ArrayList<Renderable>();
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        for (Renderable object: renderableObj)
            object.pintar(g2d);
    }

    public static void addRendereableObj(Renderable object){
        renderableObj.add(object);
        Collections.sort(renderableObj);
    }
    public static void borrarRendereableObj(Renderable object){
        renderableObj.remove(object);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension((int)ventana.getvAncho() +1, (int) ventana.getvAlto()+1);

    }
}

package update;

import objetos.Fondo;
import renders.Renderable;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public interface Updateable {
    public void update() throws IOException;

    double getX();

    double getY();
    public  String getID();
    public Renderable getRenderable();

    public default Updateable colisionando(Renderable thisObject, String otherObjectID){
        ArrayList<Updateable> objetos = Updater.getUpdateableObj();
        for (Updateable object: objetos)
            if(object.getID()==otherObjectID)
                if (thisObject.getX() < object.getRenderable().getX() +
                    object.getRenderable().getAncho() && thisObject.getX() + thisObject.getAncho() > object.getRenderable().getX())
                    if (thisObject.getY() < object.getRenderable().getY() + object.getRenderable().getAlto() && thisObject.getY()
                        + thisObject.getAlto() > object.getRenderable().getY())
                        return object;
        return null;

    }



}

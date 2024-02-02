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
    // kpublic double obj_y = thisObject.getX();




}

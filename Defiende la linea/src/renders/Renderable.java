package renders;

import java.awt.*;

public interface Renderable  extends Comparable<Object>{
    public void pintar(Graphics2D g);
    public int obtLayer();
    public double getX();
    public  double getY();
    public double getAncho();
    public double getAlto();
    public default int compareTo(Object o){
        Renderable object = (Renderable)o;

        if (this.obtLayer() < object.obtLayer())
            return -1;
        else  if (this.obtLayer() > object.obtLayer())
            return 1;
        else
            return 0;
    }
}

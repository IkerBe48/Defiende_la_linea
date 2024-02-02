package update;

import java.io.IOException;
import java.util.ArrayList;

public class Updater {
    private static ArrayList<Updateable> updateableObj = new ArrayList<Updateable>();
    private static ArrayList<Updateable> addupdateableObj = new ArrayList<Updateable>();
    private static ArrayList<Updateable> borrarupdateableObj = new ArrayList<Updateable>();

    public static void update() throws IOException {
        for (Updateable object: updateableObj)
            object.update();

        updateableObj.removeAll(borrarupdateableObj);
        updateableObj.addAll(addupdateableObj);

        addupdateableObj.clear();
        borrarupdateableObj.clear();
    }

    public static void AddupdateableObj(Updateable object){
        addupdateableObj.add(object);
    }

    public static void BorrarupdateableObj (Updateable object){
        borrarupdateableObj.add(object);
    }
    public static ArrayList<Updateable> getUpdateableObj (){
        return updateableObj;
    }
}

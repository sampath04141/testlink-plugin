package nz.co.foodstuffs;

import java.util.ResourceBundle;

public class ReadProperty {
    static String filePath;
    static String fileLocation;

    public ReadProperty() {
    }

    public static String getFile() {
        final ResourceBundle bundle = ResourceBundle.getBundle("environment.data");
        fileLocation = bundle.getString("filePath");

        return filePath = fileLocation + bundle.getString("fileName");

    }


}

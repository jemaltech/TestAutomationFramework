package utilities;

import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();



   // private static String propertyFilePath = System.getProperty("user.dir")+"\\appAutomation-framework\\src\\resources\\configuration.properties";
    private static String url;
    private static String userName;
    private static String passWord;


    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData(){

        try (InputStream input = PropertyManager.class.getClassLoader().getResourceAsStream("config.properties")){

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("app.url"));
            System.out.println(prop.getProperty("app.userName"));
            System.out.println(prop.getProperty("app.passWord"));

            //Get properties from configuration.properties
            url = prop.getProperty("app.url");
            userName = prop.getProperty("app.userName");
            passWord = prop.getProperty("app.passWord");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getURL () {
        return url;
    }

    public String getValidUsername () {
        return userName;
    }

    public String getValidPassword () {
        return passWord;
    }

}

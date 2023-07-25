import java.io.*;
import java.util.*;

public class ConfigJava implements Serializable 
{ 
    private HashMap<String, String> configJava;
    public ConfigJava() 
    {
        configJava = new HashMap<String, String>();
    }
    public void setVal(String key, String value) 
    { 
        configJava.put(key, value);
    }
    public String getVal(String key) 
    { 
        return configJava.get(key);
    }
    public static void main(String[] args) 
    {
        ConfigJava configJava;
        File fileconfig = new File("/Users/vanshikagoel/Desktop/OOAD/Lab/Week 7/config.cfg");
        if (fileconfig.exists()) 
        { 
            try 
            {
                FileInputStream fileInputStream = new FileInputStream(fileconfig); 
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
                configJava = (ConfigJava) objectInputStream.readObject();
                objectInputStream.close();
            } 
            catch (IOException | ClassNotFoundException e) 
            {
                 e.printStackTrace();
                return;
            }
        } 
        else 
        {
            configJava = new ConfigJava(); 
        }
        configJava.setVal("Path", "//Users/vanshikagoel/PES1UG20CS484/"); 
        configJava.setVal("Version", "12.3.1"); 
        configJava.setVal("SystemName", "PES1UG20CS484");
        configJava.setVal("Language", "English"); 
        configJava.setVal("Operating System", "macOS");
        try 
        {
            FileOutputStream fileOutputStream = new FileOutputStream(fileconfig); 
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
            objectOutputStream.writeObject(configJava);
            objectOutputStream.close();
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
            return;
        }
        System.out.println("config.cfg file has these values:");
        System.out.println("1. Path: " + configJava.getVal("Path")); 
        System.out.println("2. Version: " + configJava.getVal("Version")); 
        System.out.println("3. System_Name: " + configJava.getVal("SystemName"));
        System.out.println("4. Language: " + configJava.getVal("Language"));
        System.out.println("5. Operating System: " + configJava.getVal("Operating System"));
    } 
}
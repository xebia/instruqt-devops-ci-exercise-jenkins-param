package com.mycompany.app;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 * Hello world!
 */
public class App
{

    private String data;

    public App() {
        
        try (InputStream input = getClass()
			.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            // Load a properties file and read the data variable
            prop.load(input);
            
            data = prop.getProperty("data");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        // Add an Exclamation mark to show how important our data is
        data = data.concat("!");
        
    }

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
    }

    private final String getMessage() {
        return data;
    }

}

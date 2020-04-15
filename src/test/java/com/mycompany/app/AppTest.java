package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDataSet() {
        try (InputStream input = getClass()
			.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            // Load a properties file and read the data variable
            prop.load(input);
			
			assertNotNull("The data property is not set.", prop.getProperty("data"));

        } catch (IOException ex) {
            fail("An IOException occured trying to load the config file.");
        }
    }
	
    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}

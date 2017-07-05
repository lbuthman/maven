package com.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

/**
 * Example 4-5. simple-weather’s Main class
 */

public class Main {
    public static void main(String[] args) throws Exception {

        //configure Log4J
        PropertyConfigurator.configure(Main.class.getClassLoader()
                .getResource("log4j.properties"));

        //read zip code from the command and supply default value
        int zipcode = 73703; //Enid, OK
        try {
            zipcode = Integer.parseInt(args[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //start the program
        new Main(zipcode).start();
    }

    private int zip;

    private Main(int zip) {
        this.zip = zip;
    }

    private void start() throws Exception {

        //retrieve data
        InputStream dataIn = new YahooRetriever().retrieve(zip);

        //parse data
        Weather weather = new YahooParser().parse(dataIn);

        //format (print) data
        System.out.println(new WeatherFormatter().format(weather));

    }
}

package com.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

/**
 * Example 4-6. simple-weather’s YahooRetriever class
 */

class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

    InputStream retrieve(int zipcode) throws Exception {
        log.info("Retrieving Weather Data");
        String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}

package sg.edu.nus.iss.vttp5_ssf_day19l.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private String weatherAPIUrl = "http://api.weatherapi.com/v1/current.json?";

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getWeatherData(String apiKey, String country, String airQuality) {
        weatherAPIUrl = weatherAPIUrl + "key="+ apiKey + "&q="+ country + "&aqi="+ airQuality;

        return restTemplate.getForEntity(weatherAPIUrl, String.class);
        // getForObject only gets the Reponse body 
        // getForEntity is to get everyth including the headers.
        
    }

    
}

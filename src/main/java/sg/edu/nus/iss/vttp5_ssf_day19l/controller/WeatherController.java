package sg.edu.nus.iss.vttp5_ssf_day19l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5_ssf_day19l.model.Weather;
import sg.edu.nus.iss.vttp5_ssf_day19l.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{country}")
    @ResponseBody
    public Weather getWeather(@PathVariable("country") String country,
            @RequestParam(name = "airQuality", required = false) String airQuality) {
        Weather weather = weatherService.getWeather(country, airQuality);

        return weather;
    }
    
}

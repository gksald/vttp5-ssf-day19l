// package sg.edu.nus.iss.vttp5_ssf_day19l.controller;

// import java.io.StringReader;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

// import sg.edu.nus.iss.vttp5_ssf_day19l.model.Carpark;
// import sg.edu.nus.iss.vttp5_ssf_day19l.model.Weather;
// import sg.edu.nus.iss.vttp5_ssf_day19l.service.CarparkService;
// import sg.edu.nus.iss.vttp5_ssf_day19l.service.WeatherService;

// import jakarta.json.Json;
// import jakarta.json.JsonObject;
// import jakarta.json.JsonReader;


// @Controller
// @RequestMapping("/demo")
// public class DemoController {

//     @Autowired
//     CarparkService carparkService;

//     @Autowired
//     WeatherService weatherService;

//     @GetMapping("/carparks")
//     @ResponseBody
//     public List<Carpark> getCarparkRates() {
//         List<Carpark> carparks = carparkService.getCarparkRates();

//         return carparks;
//     }

//     @GetMapping("/weather")
//     @ResponseBody
//     public Weather getMethodName(@RequestParam("apiKey") String apiKey, @RequestParam("country") String country, @RequestParam("airQuality") String airQuality) {
//         ResponseEntity<String> resWeather = weatherService.getWeatherData(apiKey, country, airQuality);


//         // use Json-P to extract out data u want to the Weather object
//         // return Weather object
//         // should be done in the Service class

//         String rawString = resWeather.getBody();

//         Weather weatherData = new Weather();

//         JsonReader jReader = Json.createReader(new StringReader(rawString));
//         JsonObject jObject = jReader.readObject();
//         weatherData.setCountry(jObject.get("location").asJsonObject().getString("country"));
//         weatherData.setRegion(jObject.get("location").asJsonObject().getString("region"));
//         weatherData.setLatitude(jObject.get("location").asJsonObject().getJsonNumber("lat").doubleValue());
//         weatherData.setLongitude(jObject.get("location").asJsonObject().getJsonNumber("lon").doubleValue());
//         weatherData.setCo(jObject.get("current").asJsonObject().get("air_quality").asJsonObject().getJsonNumber("co").doubleValue());
//         weatherData.setPm2_5(jObject.get("current").asJsonObject().get("air_quality").asJsonObject().getJsonNumber("pm2_5").doubleValue());

//         return weatherData;
//     }
// }

    
    


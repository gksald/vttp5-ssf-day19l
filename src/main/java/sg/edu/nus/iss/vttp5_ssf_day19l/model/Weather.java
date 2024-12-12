package sg.edu.nus.iss.vttp5_ssf_day19l.model;

import jakarta.json.JsonObject;

public class Weather {
    private String name;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;

    // Air Quality fields (only populated when aqi=yes)
    private Double co;
    private Double o3;
    private Double so2;
    private Double pm2_5;
    private Double pm10;
    private Double no2;

    public Weather(String name, String region, String country, Double latitude, Double longitude) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setAirQualityData(JsonObject airQuality) {
        if (airQuality != null) {
            this.co = airQuality.getJsonNumber("co").doubleValue(); // retrieves the numeric value for the key "co" and converts the value to a double.
            this.o3 = airQuality.getJsonNumber("o3").doubleValue();
            this.so2 = airQuality.getJsonNumber("so2").doubleValue();
            this.pm2_5 = airQuality.getJsonNumber("pm2_5").doubleValue();
            this.pm10 = airQuality.getJsonNumber("pm10").doubleValue();
            this.no2 = airQuality.getJsonNumber("no2").doubleValue();
        }
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getCo() {
        return co;
    }

    public Double getO3() {
        return o3;
    }

    public Double getSo2() {
        return so2;
    }

    public Double getPm2_5() {
        return pm2_5;
    }

    public Double getPm10() {
        return pm10;
    }

    public Double getNo2() {
        return no2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public void setO3(Double o3) {
        this.o3 = o3;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public void setPm2_5(Double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    

}
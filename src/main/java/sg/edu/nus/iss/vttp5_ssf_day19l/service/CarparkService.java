// package sg.edu.nus.iss.vttp5_ssf_day19l.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.RequestEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import sg.edu.nus.iss.vttp5_ssf_day19l.model.Carpark;

// @Service
// public class CarparkService {
    
//     RestTemplate restTemplate = new RestTemplate();

//     public List<Carpark> getCarparkRates() {
        
//         @SuppressWarnings("rawtypes")
//         RequestEntity req = RequestEntity
//             .get("http://localhost:3000/api/carparks/rates")
//             .build();
//         ResponseEntity<List<Carpark>> resCarparkRates = restTemplate.exchange(req, new ParameterizedTypeReference<List<Carpark>>() {});
    
//         List<Carpark> carparkRates = new ArrayList<>();
        
//         carparkRates = resCarparkRates.getBody();

//         return carparkRates;
//     }

// }


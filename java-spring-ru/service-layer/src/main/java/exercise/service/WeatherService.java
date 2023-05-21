package exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.HttpClient;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.pro.packaged.S;
import org.springframework.stereotype.Service;
import exercise.CityNotFoundException;
import exercise.repository.CityRepository;
import exercise.model.City;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class WeatherService {

    @Autowired
    CityRepository cityRepository;

    // Клиент
    HttpClient client;

    // При создании класса сервиса клиент передаётся снаружи
    // В теории это позволит заменить клиент без изменения самого сервиса
    WeatherService(HttpClient client) {
        this.client = client;
    }

    // BEGIN
    public Map<String, String> requestWeatherById(Long id) throws JsonProcessingException {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));
        String url = "http://weather/api/v2/cities/" + city.getName();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(client.get(url), Map.class);
    }

    public List<Map<String, String>> requestWeatherByName(String name) throws JsonProcessingException {
        List<Map<String, String>> resultList = new ArrayList<>();
        Iterable<City> cities;
        ObjectMapper objectMapper = new ObjectMapper();
        if (name.isEmpty()) {
            cities = cityRepository.findAllByOrderByName();
        } else {
            cities = cityRepository.findByNameStartingWithIgnoreCase(name);
        }
        for (City city : cities) {
            String url = "http://weather/api/v2/cities/" + city.getName();
            String weatherJson = client.get(url);
            Map<String, String> weatherMap = objectMapper.readValue(weatherJson, Map.class);
            resultList.add(Map.of("name", weatherMap.get("name"),
                    "temperature", weatherMap.get("temperature")));
        }
        return resultList;
    }
    // END
}

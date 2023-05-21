package exercise.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map<String, String> getWeatherCity(@PathVariable Long id) throws JsonProcessingException {
        return weatherService.requestWeatherById(id);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getWeatherCity(@RequestParam(defaultValue = "") String name) throws JsonProcessingException {
        return weatherService.requestWeatherByName(name);
    }
    // END
}


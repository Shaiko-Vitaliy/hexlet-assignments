package exercise;

import exercise.daytimes.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    Daytime daytime;

    @GetMapping(path = "/daytime")
    public String getDaytime() {
        return daytime.getName();
    }
}
// END

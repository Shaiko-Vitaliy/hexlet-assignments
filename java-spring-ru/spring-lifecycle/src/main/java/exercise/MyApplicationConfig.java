package exercise;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import exercise.daytimes.Daytime;
import exercise.daytimes.Morning;
import exercise.daytimes.Day;
import exercise.daytimes.Evening;
import exercise.daytimes.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BEGIN
@Configuration
public class MyApplicationConfig {
    @Bean
    public Daytime getDayTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int time = localDateTime.getHour();
        if (time >= 6 & time < 12) {
            return new Morning();
        }
        if (time >= 12 & time < 18) {
            return new Day();
        }
        if (time >= 18 & time < 23) {
            return new Evening();
        }
        return new Night();
    }
}
// END

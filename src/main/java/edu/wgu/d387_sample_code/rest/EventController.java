package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.timezone.TimezoneConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timezone")
@CrossOrigin("http://localhost:4200")
public class EventController {

    @GetMapping("/presentations")
    public List<String> getTimes(){
        TimezoneConverter tz = new TimezoneConverter();
        return tz.getDates();
    }

}

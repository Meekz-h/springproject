package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.translator.ResourceGrabber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;


@RestController
@RequestMapping("/resource")
@CrossOrigin("http://localhost:4200")
public class ResourceController {

    static ExecutorService messageExecutor=newFixedThreadPool(2);
    @GetMapping("/welcome")
    public List<String>getMessage(){
        List<String> message = new ArrayList<String>();

        messageExecutor.execute(() -> {

            ResourceGrabber en = new ResourceGrabber();
            String welcomeMessage = en.getMessage("welcome_en_US.properties");
            message.add(welcomeMessage);
        });

        messageExecutor.execute(()->{

            ResourceGrabber fr = new ResourceGrabber();
            String welcomeMessage = fr.getMessage("welcome_fr_CA.properties");
            message.add(welcomeMessage);
        });

        return message;
    }
}

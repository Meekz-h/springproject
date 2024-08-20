package edu.wgu.d387_sample_code.translator;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceGrabber {
    private String message;

    Properties properties = new Properties();

    public String getMessage(String property) {
        try {
            InputStream stream = new ClassPathResource(property).getInputStream();
            properties.load(stream);
            message = properties.getProperty("welcome");
        } catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }
}

package com.dataintimate.lms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@SpringBootApplication
public class WebAppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WebAppInitializer.class);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

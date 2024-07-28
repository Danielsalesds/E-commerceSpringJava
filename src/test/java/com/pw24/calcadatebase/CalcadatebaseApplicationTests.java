package com.pw24.calcadatebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pw24.calcadatebase.domain.Calca;


@SpringBootApplication
public class CalcadatebaseApplicationTests implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CalcadatebaseApplicationTests.class, args);

        Calca calca = new Calca();
    }
}


package springbootrest.cinemadb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"springbootrest.cinemadb",
                                            "springbootrest.cinemadb.service",
                                            "springbootrest.cinemadb.model",
                                            "springbootrest.cinemadb.controllers"})
public class SpringBootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

}
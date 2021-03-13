package com.waracle;

import com.waracle.model.Cake;
import com.waracle.repository.CakeRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.waracle", "com.waracle.api", "com.waracle.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

    // TODO: Read it from parameter file
    private static final String URI_DATA_SOURCE = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    @Bean
    public CommandLineRunner runner(final RestTemplate restTemplate, final CakeRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                // List<Cake> cakes = restTemplate.getForObject(URI_DATA_SOURCE, List.class);
                ResponseEntity<List<Cake>> response = restTemplate.exchange(URI_DATA_SOURCE, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cake>>() {
                    });
                List<Cake> cakes = response.getBody();
                repository.saveAll(cakes);
            }
        };
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {

        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}

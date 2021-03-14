package com.waracle.api;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ivgraai
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CakesApiControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private CakesApiController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnSwaggerUi() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/swagger-ui.html", String.class)).contains("id=\"swagger-ui-container\"");
    }

}

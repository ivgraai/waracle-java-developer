package com.waracle.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.model.Cake;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ivgraai
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CakesApiControllerTests {

    @LocalServerPort
    private int port;
    @Autowired
    private CakesApiController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnSwaggerUi() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/swagger-ui.html", String.class))
                .contains("id=\"swagger-ui-container\"");
    }

    @Test
    public void shouldBeAccessibleNewCake() throws Exception {
        Cake body = new Cake().title("Zserbo szelet").desc("Nepszeru es kedvelt magyar eredetu sutemeny").image("https://hu.wikipedia.org/wiki/Zserb%C3%B3#/media/F%C3%A1jl:ZserboSzelet.JPG");
        this.mockMvc.perform(get("/cakes").header("Accept", "application/json")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(not(containsString(body.getTitle()))));
        this.mockMvc.perform(post("/cakes").contentType(MediaType.APPLICATION_JSON).content(asJsonString(body))).andExpect(status().isOk());
        this.mockMvc.perform(get("/cakes").header("Accept", "application/json")).andDo(print())
                .andExpect(jsonPath("$.[?(@.title == '" + body.getTitle() + "')]").exists());
    }

    private String asJsonString(final Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

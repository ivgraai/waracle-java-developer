package com.waracle.api;

import com.waracle.model.Cake;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.repository.CakeRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-12T11:39:55.360Z")

@Controller
public class CakesApiController implements CakesApi {

    private static final Logger LOG = LoggerFactory.getLogger(CakesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CakeRepository repository;

    @org.springframework.beans.factory.annotation.Autowired
    public CakesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<List<Cake>> cakesGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> cakesPost(@ApiParam(value = "", required = true) @Valid @RequestBody Cake body) {
        String accept = request.getHeader("Accept");
        repository.save(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

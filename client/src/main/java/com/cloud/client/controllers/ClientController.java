package com.cloud.client.controllers;

import com.cloud.client.clients.ProducerClient;
import com.cloud.client.services.HystrixDemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ProducerClient producerClient;
    @Autowired
    private HystrixDemoService hystrixDemoService;

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        String output = "I have retrieved: " + producerClient.getDummyData();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @GetMapping("/demoHystrix")
    public ResponseEntity<String> demoHystrix() {
        String output = "I have retrieved: " + hystrixDemoService.getDummyData();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}

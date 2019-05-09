package com.cloud.client.clients;

import org.springframework.stereotype.Component;

@Component
public class ProducerFallback implements ProducerClient{

    @Override
    public String getDummyData() {
        return "hystrix + feign";
    }
}

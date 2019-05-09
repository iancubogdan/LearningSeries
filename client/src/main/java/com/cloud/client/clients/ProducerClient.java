package com.cloud.client.clients;

import com.cloud.client.configurations.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "feignClient",
            url = "${feign.client.url}",
            configuration = FeignClientConfiguration.class,
            fallback = ProducerFallback.class)
public interface ProducerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/dummyData")
    String getDummyData();
}

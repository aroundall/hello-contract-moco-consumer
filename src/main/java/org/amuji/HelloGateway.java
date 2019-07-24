package org.amuji;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloGateway {
    @Value("${hello-service.rootUrl}")
    private String rootUrl;

    public String getHello(String name) {
        return new RestTemplate().getForObject(String.format("%s/hellos/%s", rootUrl, name), String.class);
    }

    public void createHellos() {
        throw new UnsupportedOperationException("I do not want to create hello patterns for now...");
    }
}

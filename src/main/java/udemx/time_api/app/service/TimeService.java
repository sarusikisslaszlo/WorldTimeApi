package udemx.time_api.app.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import udemx.time_api.app.domain.WorldTimeApi;

import java.util.concurrent.CompletableFuture;

@Service
public class TimeService {

    private static final Logger logger = LoggerFactory.getLogger(TimeService.class);
    private final RestTemplate restTemplate;

    private WorldTimeApi wta;

    public TimeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<WorldTimeApi> displayTime() throws InterruptedException {
        logger.info("Time display");
        String url = String.format("http://worldtimeapi.org/api/timezone/Europe/Budapest");
        WorldTimeApi results = restTemplate.getForObject(url, WorldTimeApi.class);
        return CompletableFuture.completedFuture(results);
    }

}

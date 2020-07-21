package udemx.time_api.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemx.time_api.app.domain.WorldTimeApi;
import udemx.time_api.app.service.TimeService;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class TimeController {

    @Autowired
    private TimeService ts;

    LocalDateTime localDate = LocalDateTime.now();

    @GetMapping("/timefromweb")
    public CompletableFuture<WorldTimeApi> getTimeFromWeb() throws InterruptedException {
        return ts.displayTime();
    }

    @GetMapping("timefrompc")
    public LocalDateTime getTimeFromPc() {
        return localDate;
    }

}

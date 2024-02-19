package pl.zajavka.integration;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import pl.zajavka.integration.configuration.AbstractIT;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MechanicControllerIT extends AbstractIT {

    @LocalServerPort
    private int port;

    @Value("${server.servlet.context-path}") //to jest Value ze springa a nie z lomboka
    private String basePath;

    private final TestRestTemplate restTemplate;//to bezie udawało zachowanie przeglądarki(klient)

    @Test
    public void homePageWorksCorrectly() {
        String url = String.format("http://localhost:%s%s/mechanic", port,basePath);
//        String url = String.format("http://localhost:%s/zajavka/employees", port);


        String renderedPage = this.restTemplate.getForObject(url, String.class);
        Assertions.assertThat(renderedPage).contains(("Check the following service requests and work on them!"));
    }
}

package com.agilepeak.adyenjackson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example of a full integration test which starts the server
 * <a href="https://spring.io/guides/gs/testing-web/">https://spring.io/guides/gs/testing-web/</a>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void checkoutActionType_is_correct_in_json_response() {
        String endpointUrl = "http://localhost:" + port + "/adyenCheckoutActionTypeExample";
        assertThat(testRestTemplate.getForObject(endpointUrl, String.class)).contains("\"type\":\"threeDS2Fingerprint\"");
    }
}

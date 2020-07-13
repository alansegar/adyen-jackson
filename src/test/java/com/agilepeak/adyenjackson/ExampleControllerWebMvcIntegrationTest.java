package com.agilepeak.adyenjackson;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Example of a lighter-weight test which doesn't start the server but still enables Jackson parsing of the response to be tested
 * <a href="https://spring.io/guides/gs/testing-web/">https://spring.io/guides/gs/testing-web/</a>
 */
@SpringBootTest
@AutoConfigureMockMvc
class ExampleControllerWebMvcIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkoutActionType_is_correct_in_json_response() throws Exception {
        String endpointUrl = "http://localhost:8080/adyenCheckoutActionTypeExample";
        mockMvc.perform(get(endpointUrl))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(content().string(Matchers.containsString("\"type\":\"threeDS2Fingerprint\"")))
            .andExpect(content().json(("{\"paymentData\":\"ExamplePaymentDataValue\",\"paymentMethodType\":\"scheme\",\"token\":\"ExampleToken\",\"resendInterval\":0,\"resendMaxAttempts\":0,\"type\":\"threeDS2Fingerprint\"}"), true));
    }
}

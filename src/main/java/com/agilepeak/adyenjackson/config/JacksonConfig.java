package com.agilepeak.adyenjackson.config;

import com.adyen.model.checkout.CheckoutPaymentsAction;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Configuration of Jackson JSON serializer to exclude null fields and use a custom serializer for CheckoutPaymentsAction.CheckoutActionType
 */
@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
            // Commenting out the following line demonstrates how the JSON looks without this customisation (THREEDS2FINGERPRINT rather than threeDS2Fingerprint)
            .serializerByType(CheckoutPaymentsAction.CheckoutActionType.class, new CheckoutActionTypeJacksonSerializer(CheckoutPaymentsAction.CheckoutActionType.class));
        return builder;
    }
}

package com.agilepeak.adyenjackson.config;

import com.adyen.model.checkout.CheckoutPaymentsAction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * Customises the behaviour of the Jackson JSON serializer to use the value of the Adyen CheckoutPaymentsAction.CheckoutActionType enum rather than the raw enum name
 */
public class CheckoutActionTypeJacksonSerializer extends StdSerializer<CheckoutPaymentsAction.CheckoutActionType> {
    public CheckoutActionTypeJacksonSerializer(Class<CheckoutPaymentsAction.CheckoutActionType> type) {
        super(type);
    }

    @Override
    public void serialize(CheckoutPaymentsAction.CheckoutActionType checkoutActionType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(checkoutActionType.getValue());
    }
}

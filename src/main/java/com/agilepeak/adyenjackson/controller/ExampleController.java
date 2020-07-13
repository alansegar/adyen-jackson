package com.agilepeak.adyenjackson.controller;

import com.adyen.model.checkout.CheckoutPaymentsAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    /**
     * Example of how to return the action object to the front-end with the type field formatted as expected by the JS.
     * <p>
     * Without a custom Jackson converter for the CheckoutActionType enum, the value will be all uppercase in the JSON which doesn't work.
     * This is due to the Adyen library containing annotations for GSON rather than Jackson.
     * <p>
     * See <a href="https://docs.adyen.com/checkout/3d-secure/native-3ds2/web-drop-in?tab=%23codeBlockVjiAh_Java#make-a-payment">https://docs.adyen.com/checkout/3d-secure/native-3ds2/web-drop-in?tab=%23codeBlockVjiAh_Java#make-a-payment</a>
     *
     * @return The action object required by the Adyen Drop-in Javascript
     */
    @GetMapping("/adyenCheckoutActionTypeExample")
    public CheckoutPaymentsAction adyenCheckoutActionTypeExample() {
        // This object is normally returned by a call to the Adyen server.
        // Here it's constructed manually for simplicity in the example
        return new CheckoutPaymentsAction()
            .type(CheckoutPaymentsAction.CheckoutActionType.THREEDS2FINGERPRINT)
            .paymentData("ExamplePaymentDataValue")
            .paymentMethodType("scheme")
            .token("ExampleToken");
    }
}

### Example of using the Adyen Java library with Spring Boot when using the default JSON (de)serializer

Adyen's Java library contains GSON annotations but Spring Boot uses Jackson rather than GSON by default so these annotation are ignored.

This repo demonstrates how to use a custom Jackson serializer to ensure the JSON output by Jackson in compatible with Adyen's drop-in JavaScript library when returning Action objects e.g. for 3D Secure.

This avoids the need to alter the internal contents of the Adyen Java library, so the standard Maven dependency can still be used.

Blog post http://alansegar.co.uk/apl/2020/07/13/adyen-java-library-with-jackson-json/

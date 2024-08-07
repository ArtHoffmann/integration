package shopify.sevdesk.shopify_sevdesk_integration_backend.service;

import org.springframework.stereotype.Service;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.HelloWorldModel;

@Service
public class HelloWorldService {

    public HelloWorldModel sayHello() {
        HelloWorldModel helloWorldModel = new HelloWorldModel();
        helloWorldModel.setId("1");
        helloWorldModel.setMessage("Hello World2");
        return helloWorldModel;
    }
}

package shopify.sevdesk.shopify_sevdesk_integration_backend.service;

import org.springframework.stereotype.Service;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.HelloWorldModel;

@Service
public class HelloWorldService {

    public HelloWorldModel sayHello() {
        var helloWorldModel = new HelloWorldModel();
        helloWorldModel.setMessage("Hello World!");
        return helloWorldModel;
    }
}

package shopify.sevdesk.shopify_sevdesk_integration_backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorldController() {
        return ResponseEntity.ok("Hello Spring Boot");
    }
}

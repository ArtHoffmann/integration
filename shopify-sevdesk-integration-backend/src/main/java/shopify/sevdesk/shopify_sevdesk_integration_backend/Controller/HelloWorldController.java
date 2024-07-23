package shopify.sevdesk.shopify_sevdesk_integration_backend.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class HelloWorldController {

    private static Logger logger = LogManager.getLogger(HelloWorldController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        logger.info("Hello World called");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body("{\"message\": \"Hello, World - test\"}");
    }

    @GetMapping("/customers")
    public String customers(Principal principal) {
        return "Welcome, " + principal.getName() + "!";
    }

}

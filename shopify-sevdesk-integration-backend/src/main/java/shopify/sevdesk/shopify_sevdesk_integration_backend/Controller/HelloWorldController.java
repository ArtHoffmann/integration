package shopify.sevdesk.shopify_sevdesk_integration_backend.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.HelloWorldService;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.HelloWorldModel;

import java.util.Optional;


@RestController
@RequestMapping("/customers")
public class HelloWorldController {
    private static Logger logger = LogManager.getLogger(HelloWorldController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloWorldModel> customers() throws ChangeSetPersister.NotFoundException {
        logger.info("HelloWorldService called");

        HelloWorldModel helloWorldModel = Optional.ofNullable(this.helloWorldService.sayHello())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        return ResponseEntity.ok(helloWorldModel);
    }
}
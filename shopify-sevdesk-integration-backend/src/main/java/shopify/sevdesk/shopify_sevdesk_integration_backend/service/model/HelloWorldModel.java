package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class HelloWorldModel {
    String id;
    String message;
}

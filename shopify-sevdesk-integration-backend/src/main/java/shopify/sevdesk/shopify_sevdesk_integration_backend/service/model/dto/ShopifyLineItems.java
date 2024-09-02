package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyLineItems {
    List<ShopifyLineItem> shopifyLineItem;
}

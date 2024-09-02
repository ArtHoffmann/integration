package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyLineItem {
    Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("product_exists")
    Boolean productExists;
    String sku;
    @JsonProperty("total_discount")
    String total_discount;
}

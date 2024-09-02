package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyShopMoney {
    String amount;
    @JsonProperty("currency_code")
    String currencyCode;
}

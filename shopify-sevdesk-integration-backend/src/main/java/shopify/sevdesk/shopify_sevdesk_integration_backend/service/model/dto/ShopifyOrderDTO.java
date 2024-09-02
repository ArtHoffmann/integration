package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderDTO {

    Long id;
    @JsonProperty("created_at")
    String createdAt;
    String currency;
    String title;
    @JsonProperty("customer_locale")
    String customerLocale;
    @JsonProperty("financial_status")
    String financialStatus;
    String name;
    @JsonProperty("order_number")
    Long orderNumber;
    @JsonProperty("processed_at")
    String processedAt;
    @JsonProperty("billing_address")
    ShopifyCustomerDTO billingAddress;
    @JsonProperty("email")
    String email;
    @JsonProperty("total_price_set")
    ShopifyTotalPriceSet totalPriceSet;
    @JsonProperty("total_shipping_price_set")
    ShopifyTotalShippingPriceSet totalShippingPriceSet;
    @JsonProperty("line_items")
    private List<ShopifyLineItem> lineItems;
}

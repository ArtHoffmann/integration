package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCustomerDTO {
    @JsonProperty("first_name")
    String firstName;
    String address1;
    String city;
    String zip;
    String country;
    @JsonProperty("last_name")
    String lastName;
    String name;
    @JsonProperty("country_code")
    String countryCode;
}

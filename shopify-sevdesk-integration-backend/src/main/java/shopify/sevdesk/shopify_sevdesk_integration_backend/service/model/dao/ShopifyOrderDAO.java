package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "shopify_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopifyOrderDAO {

    @Id
    private Long id;

    @Column(length = 3)
    private String currency;

    @Column(length = 50)
    private String name;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "email")
    private String email;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "total_price_set", precision = 10, scale = 2)
    private BigDecimal totalPriceSet;

    @Column(name = "total_shipping_price_set", precision = 10, scale = 2)
    private BigDecimal totalShippingPriceSet;

    @Column(name = "customer_locale", length = 10)
    private String customerLocale;

    @Column(name = "financial_status", length = 20)
    private String financialStatus;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "processed_at")
    private String processedAt;

    @Column(name = "billing_address_address1", length = 255)
    private String billingAddressAddress1;

    @Column(name = "billing_address_city", length = 100)
    private String billingAddressCity;

    @Column(name = "billing_address_zip", length = 20)
    private String billingAddressZip;

    @Column(name = "billing_address_country", length = 100)
    private String billingAddressCountry;

    @Column(name = "billing_address_name", length = 255)
    private String billingAddressName;

    @Column(name = "billing_address_country_code", length = 2)
    private String billingAddressCountryCode;

    @Column(name = "billing_address_first_name", length = 100)
    private String billingAddressFirstName;

    @Column(name = "billing_address_last_name", length = 100)
    private String billingAddressLastName;

}
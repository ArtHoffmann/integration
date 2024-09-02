package shopify.sevdesk.shopify_sevdesk_integration_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.ShopifyService;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto.ShopifyOrdersDTO;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/shopify")
public class ShopifyController {

    @Autowired
    private ShopifyService shopifyService;

    @GetMapping("/orders")
    public ShopifyOrdersDTO getShopifyOrders() throws URISyntaxException, IOException, InterruptedException {
        return shopifyService.shopifyOrders();
    }
}

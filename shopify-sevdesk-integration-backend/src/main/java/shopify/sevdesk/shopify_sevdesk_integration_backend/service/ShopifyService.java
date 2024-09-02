package shopify.sevdesk.shopify_sevdesk_integration_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopify.sevdesk.shopify_sevdesk_integration_backend.repository.ShopifyOrderRepository;
import shopify.sevdesk.shopify_sevdesk_integration_backend.controller.ShopifyController;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dao.ShopifyOrderDAO;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto.ShopifyOrdersDTO;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.mapper.ShopifyOrderMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ShopifyService {

    @Value("${shopify.api.token}")
    private String shopifyApiToken;
    private static Logger logger = LogManager.getLogger(ShopifyController.class);
    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ShopifyOrderRepository shopifyOrderRepository;
    private final ShopifyOrderMapper shopifyOrderMapper;

    public ShopifyService(ShopifyOrderRepository shopifyOrderRepository,
                          ShopifyOrderMapper shopifyOrderMapper) {
        this.shopifyOrderRepository = shopifyOrderRepository;
        this.shopifyOrderMapper = shopifyOrderMapper;
    }

    private HttpRequest fetchShopifyOrders() throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI("https://zrshop-de.myshopify.com/admin/api/2024-07/orders.json?status=any"))
                .header("X-Shopify-Access-Token", shopifyApiToken)
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    public List<ShopifyOrderDAO> insertOrdersInDatabase(ShopifyOrdersDTO shopifyOrdersDTO) {
        List<ShopifyOrderDAO> shopifyOrderDAOS = shopifyOrderMapper.dtosToDAOs(shopifyOrdersDTO.getOrders());
        return shopifyOrderRepository.saveAll(shopifyOrderDAOS);
    }


    public ShopifyOrdersDTO shopifyOrders() throws URISyntaxException, IOException, InterruptedException {
        logger.info("Start fetching shopify orders");
        HttpRequest shopifyRequest = this.fetchShopifyOrders();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(shopifyRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            try {
                ShopifyOrdersDTO orders = objectMapper.readValue(response.body(), ShopifyOrdersDTO.class);
                List<ShopifyOrderDAO> shopifyOrderDAOS = insertOrdersInDatabase(orders);
                return orders;
            } catch (Exception e) {
                logger.error("Error deserializing Shopify orders: " + e.getMessage(), e);
                throw new RuntimeException("Failed to deserialize Shopify orders", e);
            }
        } else {
            logger.error("Error fetching Shopify orders. Status code: " + response.statusCode());
            throw new RuntimeException("Failed to fetch Shopify orders");
        }
    }
}

package shopify.sevdesk.shopify_sevdesk_integration_backend.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.mapper.ShopifyOrderMapper;

@Configuration
public class MapStructConfig {

    @Bean
    public ShopifyOrderMapper shopifyOrderMapper() {
        return Mappers.getMapper(ShopifyOrderMapper.class);
    }
}
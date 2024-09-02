package shopify.sevdesk.shopify_sevdesk_integration_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "shopify.sevdesk.shopify_sevdesk_integration_backend.repository")
public class ShopifySevdeskIntegrationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifySevdeskIntegrationBackendApplication.class, args);
	}

}

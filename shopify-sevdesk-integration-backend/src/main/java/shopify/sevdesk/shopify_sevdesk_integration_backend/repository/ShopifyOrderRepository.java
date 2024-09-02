package shopify.sevdesk.shopify_sevdesk_integration_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dao.ShopifyOrderDAO;

@Repository
public interface ShopifyOrderRepository extends JpaRepository<ShopifyOrderDAO, Long> {}
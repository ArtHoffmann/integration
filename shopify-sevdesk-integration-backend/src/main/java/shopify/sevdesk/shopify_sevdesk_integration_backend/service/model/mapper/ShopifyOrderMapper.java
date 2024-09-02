package shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dao.ShopifyOrderDAO;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto.ShopifyLineItem;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto.ShopifyLineItems;
import shopify.sevdesk.shopify_sevdesk_integration_backend.service.model.dto.ShopifyOrderDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ShopifyOrderMapper {

    @Mappings({
            @Mapping(target = "productTitle", source = "lineItems", qualifiedByName = "getProductTitle"),
            @Mapping(target = "totalPriceSet", source = "totalPriceSet.shopifyTotalMoney.amount"),
            @Mapping(target = "totalShippingPriceSet", source = "totalShippingPriceSet.shopifyTotalMoney.amount"),
            @Mapping(target = "billingAddressAddress1", source = "billingAddress.address1"),
            @Mapping(target = "billingAddressCity", source = "billingAddress.city"),
            @Mapping(target = "billingAddressZip", source = "billingAddress.zip"),
            @Mapping(target = "billingAddressCountry", source = "billingAddress.country"),
            @Mapping(target = "billingAddressName", source = "billingAddress.name"),
            @Mapping(target = "billingAddressCountryCode", source = "billingAddress.countryCode"),
            @Mapping(target = "billingAddressFirstName", source = "billingAddress.firstName"),
            @Mapping(target = "billingAddressLastName", source = "billingAddress.lastName"),
    })
    ShopifyOrderDAO dtoToDao(ShopifyOrderDTO dto);

    @Mappings({
            @Mapping(target = "lineItems", source = "productTitle", qualifiedByName = "createLineItems"),
            @Mapping(target = "totalPriceSet.shopifyTotalMoney.amount", source = "totalPriceSet"),
            @Mapping(target = "totalShippingPriceSet.shopifyTotalMoney.amount", source = "totalShippingPriceSet"),
            @Mapping(target = "billingAddress.address1", source = "billingAddressAddress1"),
            @Mapping(target = "billingAddress.city", source = "billingAddressCity"),
            @Mapping(target = "billingAddress.zip", source = "billingAddressZip"),
            @Mapping(target = "billingAddress.country", source = "billingAddressCountry"),
            @Mapping(target = "billingAddress.name", source = "billingAddressName"),
            @Mapping(target = "billingAddress.countryCode", source = "billingAddressCountryCode"),
            @Mapping(target = "billingAddress.firstName", source = "billingAddressFirstName"),
            @Mapping(target = "billingAddress.lastName", source = "billingAddressLastName"),
    })
    ShopifyOrderDTO daoToDto(ShopifyOrderDAO dao);

    @Named("getProductTitle")
    default String getProductTitle(List<ShopifyLineItem> lineItems) {
        if (lineItems != null && !lineItems.isEmpty()) {
            return lineItems.stream()
                    .map(ShopifyLineItem::getTitle)
                    .filter(name -> name != null && !name.isEmpty())
                    .collect(Collectors.joining(", "));
        }
        return null;
    }

    @Named("createLineItems")
    default List<ShopifyLineItem> createLineItems(String productTitle) {
        if (productTitle != null && !productTitle.isEmpty()) {
            ShopifyLineItem item = new ShopifyLineItem();
            item.setTitle(productTitle);
            return List.of(item);
        }
        return null;
    }

    List<ShopifyOrderDAO> dtosToDAOs(List<ShopifyOrderDTO> dtos);

    List<ShopifyOrderDTO> daosToDto(List<ShopifyOrderDAO> daos);

}
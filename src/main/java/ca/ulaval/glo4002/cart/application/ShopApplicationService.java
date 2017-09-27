package ca.ulaval.glo4002.cart.application;

import java.util.List;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class ShopApplicationService {

    private ShopItemAssembler shopItemAssembler;
    private ShopRepository shopRepository;

    public ShopApplicationService() {
        this.shopRepository = ServiceLocator.INSTANCE.resolve(ShopRepository.class);
        this.shopItemAssembler = new ShopItemAssembler(); // Could also be in the service locator
    }

    public List<ShopItemDto> listAvailableItems() {
        List<ShopItem> items = shopRepository.getAvailableItems();
        return shopItemAssembler.toDto(items);
    }

    public ShopItem findItemBySku(String sku) {
        return shopRepository.getAvailableItems().stream().filter(x -> x.hasSku(sku)).findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }
}

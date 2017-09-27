package ca.ulaval.glo4002.cart.infrastructure.persistence.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

import static java.util.stream.Collectors.toList;

public class InMemoryShopRepository implements ShopRepository {
    private static final Map<String, ShopItem> ITEMS = new HashMap<>();

    @Override
    public List<ShopItem> getAvailableItems() {
        return ITEMS.values().stream().filter(x -> x.isAvailable()).collect(toList());
    }

    @Override
    public void insert(ShopItem item) {
        ITEMS.put(item.getSku(), item);
    }
}

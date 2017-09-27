package ca.ulaval.glo4002.cart.context.configuration;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.cart.InMemoryCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.shop.InMemoryShopRepository;

public class InMemoryPersistenceConfiguration implements Configuration {
    @Override
    public void apply() {
        ServiceLocator.INSTANCE.register(CartRepository.class, new InMemoryCartRepository());
        ServiceLocator.INSTANCE.register(ShopRepository.class, new InMemoryShopRepository());
    }
}

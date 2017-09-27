package ca.ulaval.glo4002.cart.context.configuration;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.cart.XmlCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.shop.XmlShopRepository;

public class XmlPersistenceConfiguration implements Configuration {
    @Override
    public void apply() {
        ServiceLocator.INSTANCE.register(CartRepository.class, new XmlCartRepository());
        ServiceLocator.INSTANCE.register(ShopRepository.class, new XmlShopRepository());
    }
}

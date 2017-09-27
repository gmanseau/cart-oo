package ca.ulaval.glo4002.cart.context.configuration;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartItemFactory;
import ca.ulaval.glo4002.cart.domain.cart.StandardCartItemFactory;

public class StandardShopConfiguration implements Configuration {
    @Override
    public void apply() {
        ServiceLocator.INSTANCE.register(CartItemFactory.class, new StandardCartItemFactory());
    }
}

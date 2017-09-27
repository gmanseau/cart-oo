package ca.ulaval.glo4002.cart.domain.cart;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public interface CartItemFactory {
    CartItem create(ShopItem shopItem);
}

package ca.ulaval.glo4002.cart.domain.cart;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public class PromoCartItemFactory implements CartItemFactory {
    public static final int PROMO_QUANTITY = 2;

    @Override
    public CartItem create(ShopItem shopItem) {
        return new CartItem(shopItem.getName(), PROMO_QUANTITY);
    }
}
